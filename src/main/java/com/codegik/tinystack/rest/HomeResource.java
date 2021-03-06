package com.codegik.tinystack.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	@GetMapping("/")
	public void homepage(HttpServletResponse response) throws IOException {
		response.sendRedirect("index.html#!/home");
	}
}
