package com.codegik.tinystack.service;

import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codegik.tinystack.domain.Profile;
import com.codegik.tinystack.domain.ProfileAnswer;
import com.codegik.tinystack.domain.ProfileAnswer.ProfileAnswerPK;
import com.codegik.tinystack.domain.ProfileInfo;
import com.codegik.tinystack.domain.ProfileInfo.ProfileInfoPK;
import com.codegik.tinystack.repository.ProfileRepository;
import com.codegik.tinystack.repository.RoleRepository;
import com.codegik.tinystack.repository.UserRepository;

@Service
@Transactional
public class ProfileService {

	private final Logger log = LoggerFactory.getLogger(ProfileService.class);

	@Inject
	private UserRepository userRepository;

	@Inject
	private ProfileRepository profileRepository;

	@Inject
	private RoleRepository roleRepository;

	public Profile create(final Profile profile) {
		profile.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		profile.getUser().withId(UUID.randomUUID().toString().replaceAll("-", ""));
		for (ProfileAnswer answer : profile.getAnswers()) {
			answer.withId(ProfileAnswerPK.create().withQuestionId(answer.getQuestion().getId())
					.withProfileId(profile.getId())).withProfile(profile);
		}
		for (ProfileInfo infos : profile.getInformations()) {
			infos.withId(ProfileInfoPK.create().withInfoId(UUID.randomUUID().toString().replaceAll("-", ""))
					.withProfileId(profile.getId())).withProfile(profile);
		}
		return profileRepository.save(profile);
	}

}
