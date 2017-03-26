package com.codegik.tinystack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.codegik.tinystack.domain.Profile;

public interface ProfileRepository
    extends JpaRepository<Profile, String>, JpaSpecificationExecutor<Profile> {


}
