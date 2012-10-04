package com.ffbit.wordset.domain;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "feedbacks")
@Access(AccessType.PROPERTY)
public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String comment;
    private HumanLanguage language;

    private Feedback() {
        super();
    }

    public Feedback(String comment, HumanLanguage language) {
        this();
        this.comment = comment;
        this.language = language;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 1024)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public HumanLanguage getLanguage() {
        return language;
    }

    public void setLanguage(HumanLanguage language) {
        this.language = language;
    }

}
