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

import com.codegik.tinystack.domain.Event;
import com.codegik.tinystack.rest.util.PaginationUtil;
import com.codegik.tinystack.service.EventService;

@RestController
@RequestMapping("/api")
public class EventResource {

	@Inject
	private EventService eventService;

	@PostMapping("/event")
	public ResponseEntity<Event> create(@Valid @RequestBody Event event) {
		return new ResponseEntity<Event>(eventService.create(event), HttpStatus.OK);
	}

	@GetMapping("/events")
	public ResponseEntity<List<Event>> findAll(Pageable pageable) throws URISyntaxException {
		Page<Event> page = eventService.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/events");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	@GetMapping("/events/{id}")
	public ResponseEntity<Event> getSalesItem(@PathVariable String id) {
		Event event = eventService.findOne(id);
		return Optional.ofNullable(event).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/events/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		eventService.delete(id);
		return ResponseEntity.ok().build();
	}
}
