package com.codegik.tinystack.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.codegik.tinystack.domain.uuid.IdentifierGenerator;

@Entity
@Table(name = "profile")
public class Profile implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "birthday")
  private Date birthday;

  @Embedded
  private Address address;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
  private List<ProfileInfo> informations;

  @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
  private List<ProfileAnswer> answers;

  public Profile generateId() {
    id = IdentifierGenerator.generate();
    return this;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<ProfileInfo> getInformations() {
    return informations;
  }

  public void setInformations(List<ProfileInfo> informations) {
    this.informations = informations;
  }

  public List<ProfileAnswer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<ProfileAnswer> answers) {
    this.answers = answers;
  }

  public static synchronized Profile create() {
    return new Profile();
  }

  public Profile withId(final String id) {
    this.id = id;
    return this;
  }

  public Profile withBirthday(final Date birthday) {
    this.birthday = birthday;
    return this;
  }

  public Profile withAddress(final Address address) {
    this.address = address;
    return this;
  }

  public Profile withInformations(final List<ProfileInfo> informations) {
    this.informations = informations;
    return this;
  }

  public Profile withAnswers(final List<ProfileAnswer> answers) {
    this.answers = answers;
    return this;
  }

  public Profile withUser(final User user) {
    this.user = user;
    return this;
  }

}
