package com.nitin.questionnaire.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "question_option")
public class Option {
    @Id
    private String id=UUID.randomUUID().toString();
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;
    @Column
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
