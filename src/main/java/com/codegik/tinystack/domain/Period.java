package com.codegik.tinystack.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Period implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "initial_date")
    private Date initialDate;

    @Column(name = "end_date")
    private Date endDate;

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public static synchronized Period create() {
        return new Period();
    }

    public Period withInitialDate(final Date initialDate) {
        this.initialDate = initialDate;
        return this;
    }

    public Period withEndDate(final Date endDate) {
        this.endDate = endDate;
        return this;
    }

}
