package com.codegik.tinystack.rest;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegik.tinystack.domain.Event;
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

}
