package com.codegik.tinystack.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "event_participant")
public class EventParticipant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Embeddable
    public static class EventParticipantPK implements Serializable {

        private static final long serialVersionUID = 1L;

        @Column(name = "event_id")
        private String eventId;

        @Column(name = "participant_id")
        private String participantId;

        public String getEventId() {
            return eventId;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
        }

        public String getParticipantId() {
            return participantId;
        }

        public void setParticipantId(String participantId) {
            this.participantId = participantId;
        }

        public static synchronized EventParticipantPK create() {
            return new EventParticipantPK();
        }

        public EventParticipantPK withEventId(final String eventId) {
            this.eventId = eventId;
            return this;
        }

        public EventParticipantPK withParticipantId(final String participantId) {
            this.participantId = participantId;
            return this;
        }

    }

    @EmbeddedId
    private EventParticipantPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User participant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Event event;

    public EventParticipantPK getId() {
        return id;
    }

    public void setId(EventParticipantPK id) {
        this.id = id;
    }

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

    public EventParticipant withId(final EventParticipantPK id) {
        this.id = id;
        return this;
    }

    public EventParticipant withParticipant(final User participant) {
        this.participant = participant;
        return this;
    }

    public EventParticipant withEvent(final Event event) {
        this.event = event;
        return this;
    }

}
