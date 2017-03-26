package com.codegik.tinystack.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegik.tinystack.domain.Question;
import com.codegik.tinystack.rest.util.PaginationUtil;
import com.codegik.tinystack.service.QuestionService;

@RestController
@RequestMapping("/api")
public class QuestionResource {

	@Inject
	private QuestionService questionService;

	@PostMapping("/question")
	public ResponseEntity<Question> create(@Valid @RequestBody Question question) {
		return new ResponseEntity<Question>(questionService.create(question), HttpStatus.OK);
	}

	@GetMapping("/questions")
	public ResponseEntity<List<Question>> findAll(Pageable pageable) throws URISyntaxException {
		Page<Question> page = questionService.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/questions");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	@GetMapping("/questions/{id}")
	public ResponseEntity<Question> getSalesItem(@PathVariable String id) {
		Question question = questionService.findOne(id);
		return Optional.ofNullable(question).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/questions/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		questionService.delete(id);
		return ResponseEntity.ok().build();
	}
}
