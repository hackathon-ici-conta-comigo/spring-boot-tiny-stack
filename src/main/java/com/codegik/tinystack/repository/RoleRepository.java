package com.codegik.tinystack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegik.tinystack.domain.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
}
