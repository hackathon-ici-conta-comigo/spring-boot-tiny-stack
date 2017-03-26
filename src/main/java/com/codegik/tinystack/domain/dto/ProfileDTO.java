package com.codegik.tinystack.domain.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.codegik.tinystack.domain.Address;

@XmlRootElement(name = "profile")
public class ProfileDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "address")
    private Address address;

    @XmlElement(name = "user")
    private UserDTO user;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public static synchronized ProfileDTO create() {
        return new ProfileDTO();
    }

    public ProfileDTO withAddress(final Address address) {
        this.address = address;
        return this;
    }

    public ProfileDTO withUser(final UserDTO user) {
        this.user = user;
        return this;
    }

}
