package com.nitin.questionnaire.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "assessment")
public class Assessment {

    @Id
    private String id = UUID.randomUUID().toString();
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String numberOfQuestions;
    @OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssessmentQuestionRelation> questionRelations;

    public Assessment() {

    }

    public Assessment(String id, String title, String description, String numberOfQuestions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.numberOfQuestions = numberOfQuestions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(String numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public List<AssessmentQuestionRelation> getQuestionRelations() {
        return questionRelations;
    }

    public void setQuestionRelations(List<AssessmentQuestionRelation> questionRelations) {
        this.questionRelations = questionRelations;
    }
}
