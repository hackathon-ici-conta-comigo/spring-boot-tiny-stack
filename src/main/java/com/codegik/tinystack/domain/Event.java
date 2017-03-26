package com.codegik.tinystack.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.codegik.tinystack.domain.uuid.IdentifierGenerator;

@Entity
@Table(name = "event")
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promoter_id")
    private User promoter;

    @OneToMany
    private List<EventParticipant> participants;

    @Embedded
    private Schedule schedule;

    public Event generateId() {
        id = IdentifierGenerator.generate();
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public User getPromoter() {
        return promoter;
    }

    public void setPromoter(User promoter) {
        this.promoter = promoter;
    }

    public List<EventParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<EventParticipant> participants) {
        this.participants = participants;
    }

    public static synchronized Event create() {
        return new Event();
    }

    public Event withId(final String id) {
        this.id = id;
        return this;
    }

    public Event withName(final String name) {
        this.name = name;
        return this;
    }

    public Event withDescription(final String description) {
        this.description = description;
        return this;
    }

    public Event withPromoter(final User promoter) {
        this.promoter = promoter;
        return this;
    }

    public Event withParticipants(final List<EventParticipant> participants) {
        this.participants = participants;
        return this;
    }

    public Event withSchedule(final Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

}
