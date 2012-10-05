package com.ffbit.wordset.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "feedbacks")
@Access(AccessType.PROPERTY)
public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String comment;
    private HumanLanguage language;
    private Set<Tag> tags;

    private Feedback() {
        super();
    }

    public Feedback(String comment, HumanLanguage language) {
        this();
        this.comment = comment;
        this.language = language;
        this.tags = new HashSet<Tag>();
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

    @OneToMany(mappedBy = "feedback", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.setFeedback(this);
    }

}
