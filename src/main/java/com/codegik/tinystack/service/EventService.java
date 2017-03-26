package com.codegik.tinystack.service;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codegik.tinystack.domain.Event;
import com.codegik.tinystack.repository.EventParticipantRepository;
import com.codegik.tinystack.repository.EventRepository;

@Service
@Transactional
public class EventService {

	@Inject
	private EventRepository eventRepository;
	
	@Inject
	private EventParticipantRepository eventParticipantRepository;


	public Event create(final Event event) {
		if (event.getId() == null) {
			event.generateId();
		}
		
		Event oldEvent = eventRepository.findOne(event.getId());
		
		if (oldEvent != null && oldEvent.getParticipants() != null && oldEvent.getParticipants().size() > 0) {
			for (int i = 0; i < oldEvent.getParticipants().size(); i++) {
				eventParticipantRepository.deleteByEventIdAndId(oldEvent.getId(), oldEvent.getParticipants().get(i).getParticipant().getId());
			}
		}

		if (event.getParticipants() != null) {
			event.getParticipants().forEach(participant -> {
				participant.generateId();
				participant.setEvent(event);
			});
		}

		return eventRepository.save(event);
	}

	public Page<Event> findAll(Pageable pageable) {
		return eventRepository.findAll(pageable);
	}

	public Event findOne(String id) {
		return eventRepository.findOne(id);
	}
	
	public void delete(String id) {
		eventRepository.delete(id);
	}
	
	public void deleteParticipant(String eventId, String id) {
		eventParticipantRepository.deleteByEventIdAndId(eventId, id);
	}
}
