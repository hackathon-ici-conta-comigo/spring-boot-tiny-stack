package com.codegik.tinystack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.codegik.tinystack.domain.EventParticipant;

public interface EventParticipantRepository extends JpaRepository<EventParticipant, String> {
	
	@Modifying
    @Transactional
    @Query("delete from EventParticipant ep where ep.event.id = ?1 and ep.participant.id = ?2")
    void deleteByEventIdAndId(String eventId, String id);
}
