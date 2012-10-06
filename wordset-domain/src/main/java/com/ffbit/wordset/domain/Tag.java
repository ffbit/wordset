package com.ffbit.wordset.domain;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "tags")
@Access(AccessType.PROPERTY)
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String word;
    private String partOfSpeech;
    private Feedback feedback;

    public Tag() {
        super();
    }

    public Tag(String word, String partOfSpeech) {
        super();
        this.word = word;
        this.partOfSpeech = partOfSpeech;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Column(nullable = false)
    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    @ManyToOne
    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word, partOfSpeech);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tag other = (Tag) obj;

        return Objects.equal(word, other.word)
                && Objects.equal(partOfSpeech, other.partOfSpeech);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("word", word)
                .add("partOfSpeech", partOfSpeech)
                .toString();
    }

}
