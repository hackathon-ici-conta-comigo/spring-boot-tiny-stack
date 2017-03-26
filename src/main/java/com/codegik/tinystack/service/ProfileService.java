package com.codegik.tinystack.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codegik.tinystack.domain.Period;
import com.codegik.tinystack.domain.Profile;
import com.codegik.tinystack.repository.ProfileRepository;
import com.codegik.tinystack.repository.specification.ProfilesByFiltersSpecification;

@Service
@Transactional
public class ProfileService {

    private final Logger log = LoggerFactory.getLogger(ProfileService.class);

    @Inject
    private ProfileRepository profileRepository;

    @Transactional(readOnly = true)
    public List<Profile> findAllByFilters(String name, Period period, String city) {
        return profileRepository.findAll(new ProfilesByFiltersSpecification(name, period, city));
    }
}
