package com.codegik.tinystack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codegik.tinystack.domain.Info;
import com.codegik.tinystack.domain.Period;
import com.codegik.tinystack.domain.Profile;
import com.codegik.tinystack.domain.ProfileAnswer;
import com.codegik.tinystack.domain.ProfileAnswer.ProfileAnswerPK;
import com.codegik.tinystack.domain.ProfileInfo;
import com.codegik.tinystack.domain.ProfileInfo.ProfileInfoPK;
import com.codegik.tinystack.domain.dto.ProfileDTO;
import com.codegik.tinystack.domain.dto.UserDTO;
import com.codegik.tinystack.repository.InfoRepository;
import com.codegik.tinystack.repository.ProfileRepository;
import com.codegik.tinystack.repository.specification.ProfilesByFiltersSpecification;

@Service
@Transactional
public class ProfileService {

    @Inject
    private ProfileRepository profileRepository;

    @Inject
    private InfoRepository InfoRepository;

    @Transactional(readOnly = true)
    public List<ProfileDTO> findAllByFilters(String name, Period period, String city) {
        final List<Profile> list = profileRepository.findAll(new ProfilesByFiltersSpecification(name, period, city));
        List<ProfileDTO> result = new ArrayList<>(list.size());
        for (Profile profile : list) {
            result.add(ProfileDTO.create().withAge(profile.getBirthday())
                    .withUser(UserDTO.create().withFirstName(profile.getUser().getFirstName()))
                    .withAddress(profile.getAddress()));
        }

        return result;
    }

    public Profile create(final Profile profile) {
        profile.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        profile.getUser().withId(UUID.randomUUID().toString().replaceAll("-", ""));
        for (ProfileInfo profileInfo : profile.getInformations()) {
            Info persistedInfo = InfoRepository.findOne(profileInfo.getInfo().getName());
            profileInfo.withId(
                    ProfileInfoPK.create().withInfoId(profileInfo.getInfo().getName()).withProfileId(profile.getId()));

            if (persistedInfo == null) {
                InfoRepository.save(profileInfo.getInfo());
            }

        }

        for (ProfileAnswer answer : profile.getAnswers()) {
            answer.withId(ProfileAnswerPK.create().withQuestionId(answer.getQuestion().getId())
                    .withProfileId(profile.getId()));
        }

        return profileRepository.save(profile);
    }

    public Page<Profile> findAll(Pageable pageable) {
        Page<Profile> page = profileRepository.findAll(pageable);
        page.forEach(profile -> {
            profile.getAnswers();
            profile.getUser();
            profile.getInformations();
            profile.getAddress();
        });
        return profileRepository.findAll(pageable);
    }

}
