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
@Table(name = "profile_answer")
public class ProfileAnswer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Embeddable
    public static class ProfileAnswerPK implements Serializable {

        private static final long serialVersionUID = 1L;
        @Column(name = "profile_id")
        private String profileId;

        @Column(name = "question_id")
        private String questionId;

        public String getProfileId() {
            return profileId;
        }

        public void setProfileId(String profileId) {
            this.profileId = profileId;
        }

        public String getQuestionId() {
            return questionId;
        }

        public void setQuestionId(String questionId) {
            this.questionId = questionId;
        }

        public static synchronized ProfileAnswerPK create() {
            return new ProfileAnswerPK();
        }

        public ProfileAnswerPK withProfileId(final String profileId) {
            this.profileId = profileId;
            return this;
        }

        public ProfileAnswerPK withQuestionId(final String questionId) {
            this.questionId = questionId;
            return this;
        }

    }

    @EmbeddedId
    private ProfileAnswerPK id;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Question question;
    
    private String answer;

    public ProfileAnswerPK getId() {
        return id;
    }

    public void setId(ProfileAnswerPK id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
      
    public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public static synchronized ProfileAnswer create() {
        return new ProfileAnswer();
    }

    public ProfileAnswer withId(final ProfileAnswerPK id) {
        this.id = id;
        return this;
    }

    public ProfileAnswer withProfile(final Profile profile) {
        this.profile = profile;
        return this;
    }

    public ProfileAnswer withQuestion(final Question question) {
        this.question = question;
        return this;
    }

}
