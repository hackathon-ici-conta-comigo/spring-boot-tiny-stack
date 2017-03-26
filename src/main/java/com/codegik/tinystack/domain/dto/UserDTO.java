package com.codegik.tinystack.domain.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "firstName")
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static synchronized UserDTO create() {
        return new UserDTO();
    }

    public UserDTO withFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

}
