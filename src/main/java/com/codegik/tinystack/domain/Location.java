package com.codegik.tinystack.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "latitude")
    private Long latitude;

    @Column(name = "longitude")
    private Long longitude;

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public static synchronized Location create() {
        return new Location();
    }

    public Location withLatitude(final Long latitude) {
        this.latitude = latitude;
        return this;
    }

    public Location withLongitude(final Long longitude) {
        this.longitude = longitude;
        return this;
    }

}
