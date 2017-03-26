package com.codegik.tinystack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegik.tinystack.domain.EventParticipant;

public interface EventParticipantRepository extends JpaRepository<EventParticipant, String> {

}
