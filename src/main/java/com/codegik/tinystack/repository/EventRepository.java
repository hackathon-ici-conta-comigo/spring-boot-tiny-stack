package com.codegik.tinystack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegik.tinystack.domain.Event;

public interface EventRepository extends JpaRepository<Event, String> {

    
}
