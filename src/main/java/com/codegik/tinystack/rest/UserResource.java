package com.codegik.tinystack.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegik.tinystack.domain.User;
import com.codegik.tinystack.rest.util.PaginationUtil;
import com.codegik.tinystack.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {

	private final Logger log = LoggerFactory.getLogger(UserResource.class);

	@Inject
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> findAll(Pageable pageable) throws URISyntaxException {
		Page<User> page = userService.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/cities");
		return new ResponseEntity<List<User>>(page.getContent(), headers, HttpStatus.OK);
	}

}
