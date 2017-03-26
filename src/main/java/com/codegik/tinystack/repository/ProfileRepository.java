package com.codegik.tinystack.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codegik.tinystack.domain.Profile;
import com.codegik.tinystack.domain.Role;

public interface ProfileRepository
    extends JpaRepository<Profile, String>, JpaSpecificationExecutor<Profile> {

  @Query("select p from Profile p inner join p.user as u where u.roles in (:role)")
  Page<Profile> findAllByRole(Pageable pageable, @Param("role") Role role);

}
