package com.codegik.tinystack.service;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codegik.tinystack.domain.Question;
import com.codegik.tinystack.repository.QuestionRepository;

@Service
@Transactional
public class QuestionService {

	@Inject
	private QuestionRepository questionRepository;


	public Question create(final Question question) {
		question.generateId();

		return questionRepository.save(question);
	}

	public Page<Question> findAll(Pageable pageable) {
		return questionRepository.findAll(pageable);
	}

	public Question findOne(String id) {
		return questionRepository.findOne(id);
	}
	
	public void delete(String id) {
		questionRepository.delete(id);
	}
}
