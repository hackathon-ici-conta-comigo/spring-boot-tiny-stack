package com.codegik.tinystack.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codegik.tinystack.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findOneByEmail(String email);

    Page<User> findAll(Pageable pageable);
}
