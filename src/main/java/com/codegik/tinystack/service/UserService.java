package com.codegik.tinystack.service;

import java.util.ArrayList;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codegik.tinystack.domain.Profile;
import com.codegik.tinystack.repository.ProfileRepository;
import com.codegik.tinystack.repository.RoleRepository;
import com.codegik.tinystack.repository.UserRepository;

@Service
@Transactional
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    @Inject
    private UserRepository userRepository;

    @Inject
    private ProfileRepository profileRepository;

    @Inject
    private RoleRepository roleRepository;

    public Profile create(final Profile profile) {
        profile.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        profile.getUser().withId(UUID.randomUUID().toString().replaceAll("-", ""))
                         .withRoles(new ArrayList<>(1));
        profile.getUser().getRoles().add(roleRepository.findOne("EMPRESA"));
        return profileRepository.save(profile);
    }
}
