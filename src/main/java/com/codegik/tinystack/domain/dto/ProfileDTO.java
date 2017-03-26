package com.codegik.tinystack.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.codegik.tinystack.domain.Address;

@XmlRootElement(name = "profile")
public class ProfileDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "address")
    private Address address;

    @XmlElement(name = "idade")
    private Integer age;

    @XmlElement(name = "user")
    private UserDTO user;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public ProfileDTO withIdade(final Integer age) {
        this.age = age;
        return this;
    }

    public ProfileDTO withAge(Date date) {
        final LocalDate fullBirthday = LocalDate.of(date.getYear(), date.getMonth() + 1, date.getDate());
        final LocalDate now = LocalDate.now();
        long daysSinceBirth = now.toEpochDay() - fullBirthday.toEpochDay();
        this.age = (int) (daysSinceBirth / 365);
        return this;
    }

}
