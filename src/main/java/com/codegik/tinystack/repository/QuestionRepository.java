package com.codegik.tinystack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegik.tinystack.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, String> {

    
}
