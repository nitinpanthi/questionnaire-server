package com.nitin.questionnaire.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
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
    private LocalDate createdOn;
    @Column
    private LocalDate lastUpdatedOn;
    @ManyToOne
    private User createdBy;
    @Column
    private Locale locale;
    @Column
    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;
    @ManyToMany
    private List<Classification> classifications;

    @OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssessmentQuestionRelation> questionRelations;

    public Assessment() {

    }

    public List<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDate getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(LocalDate lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
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

    public List<AssessmentQuestionRelation> getQuestionRelations() {
        return questionRelations;
    }

    public void setQuestionRelations(List<AssessmentQuestionRelation> questionRelations) {
        this.questionRelations = questionRelations;
    }
}
