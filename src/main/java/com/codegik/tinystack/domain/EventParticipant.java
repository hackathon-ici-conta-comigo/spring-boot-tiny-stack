package com.codegik.tinystack.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.codegik.tinystack.domain.uuid.IdentifierGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "event_participant")
public class EventParticipant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private User participant;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    public User getParticipant() {
        return participant;
    }

    public void setParticipant(User participant) {
        this.participant = participant;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public static synchronized EventParticipant create() {
        return new EventParticipant();
    }

    public EventParticipant withParticipant(final User participant) {
        this.participant = participant;
        return this;
    }

    public EventParticipant withEvent(final Event event) {
        this.event = event;
        return this;
    }
    
    public EventParticipant generateId() {
        id = IdentifierGenerator.generate();
        return this;
    }
}
