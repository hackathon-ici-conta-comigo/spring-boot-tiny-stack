package com.codegik.tinystack.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Embedded
    private Period period;

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public static synchronized Schedule create() {
        return new Schedule();
    }

    public Schedule withPeriod(final Period period) {
        this.period = period;
        return this;
    }

}
