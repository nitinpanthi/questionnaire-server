package com.nitin.questionnaire.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
    private List<Option> options = new ArrayList<>();
    @OneToMany(mappedBy = "question")
    private List<Option> correctAnswers = new ArrayList<>();
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssessmentQuestionRelation> assessmentQuestionRelations;
    @Column
    private LocalDate createdOn;
    @Column
    private DifficultyLevel difficultyLevel;
    @Column
    private Locale locale;
    @Column
    private String createdBy;
    @ManyToMany
    private List<Classification> classifications;

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

    public List<Option> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(List<Option> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public List<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }
}
