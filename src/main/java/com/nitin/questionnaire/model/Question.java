package com.nitin.questionnaire.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "question")
public class Question {
    @Id
    private String id= UUID.randomUUID().toString();
    @Column
    private String title;
    @Column
    private int weightage;
    @Column
    private String description;
    @OneToMany(mappedBy = "question")
    private List<Option> options;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssessmentQuestionRelation> assessmentQuestionRelations;

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

    public int getWeightage() {
        return weightage;
    }

    public void setWeightage(int weightage) {
        this.weightage = weightage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public List<AssessmentQuestionRelation> getAssessmentQuestionRelations() {
        return assessmentQuestionRelations;
    }

    public void setAssessmentQuestionRelations(List<AssessmentQuestionRelation> assessmentQuestionRelations) {
        this.assessmentQuestionRelations = assessmentQuestionRelations;
    }
}
