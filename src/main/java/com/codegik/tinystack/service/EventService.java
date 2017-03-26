package com.codegik.tinystack.service;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codegik.tinystack.domain.Event;
import com.codegik.tinystack.repository.EventRepository;


@Service
@Transactional
public class EventService {
	
	@Inject
	private EventRepository eventRepository;
	
    public Event create(final Event event) {
    	event.generateId();
    	
        return eventRepository.save(event);
    }
    
    public Page<Event> findAll(Pageable pageable) {
    	return eventRepository.findAll(pageable);
    }
    
    public Event findOne(String id) {
    	return eventRepository.findOne(id);
    }
}
