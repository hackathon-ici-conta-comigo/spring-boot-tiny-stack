package com.codegik.tinystack.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "profile_info")
public class ProfileInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  @Embeddable
  public static class ProfileInfoPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "profile_id")
    private String profileId;

    @Column(name = "info_id")
    private String infoId;

    public String getProfileId() {
      return profileId;
    }

    public void setProfileId(String profileId) {
      this.profileId = profileId;
    }

    public String getInfoId() {
      return infoId;
    }

    public void setInfoId(String infoId) {
      this.infoId = infoId;
    }

    public static synchronized ProfileInfoPK create() {
      return new ProfileInfoPK();
    }

    public ProfileInfoPK withProfileId(final String profileId) {
      this.profileId = profileId;
      return this;
    }

    public ProfileInfoPK withInfoId(final String infoId) {
      this.infoId = infoId;
      return this;
    }

  }

  @EmbeddedId
  private ProfileInfoPK id;

  @ManyToOne
  @JoinColumn(name = "profile_id", referencedColumnName = "id", updatable = false,
      insertable = false)
  private Profile profile;

  @ManyToOne
  @JoinColumn(name = "info_id", referencedColumnName = "name", updatable = false,
      insertable = false)
  private Info info;

  public ProfileInfoPK getId() {
    return id;
  }

  public void setId(ProfileInfoPK id) {
    this.id = id;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }

  public static synchronized ProfileInfo create() {
    return new ProfileInfo();
  }

  public ProfileInfo withId(final ProfileInfoPK id) {
    this.id = id;
    return this;
  }

  public ProfileInfo withProfile(final Profile profile) {
    this.profile = profile;
    return this;
  }

  public ProfileInfo withInfo(final Info info) {
    this.info = info;
    return this;
  }

}
