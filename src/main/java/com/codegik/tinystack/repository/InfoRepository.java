package com.codegik.tinystack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegik.tinystack.domain.Info;

public interface InfoRepository extends JpaRepository<Info, String>  {

}
