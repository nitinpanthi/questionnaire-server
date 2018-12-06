package com.nitin.questionnaire.endpoint.rest.request.assessment;

import com.nitin.questionnaire.model.DifficultyLevel;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class AssessmentCreationRequest {

    private String name;
    private String description;
    private List<String> classifications;
    private DifficultyLevel difficultyLevel = DifficultyLevel.EASY;
    private Locale locale = Locale.ENGLISH;
    private String createdBy;
    private LocalDate lastUpdateDate = LocalDate.now();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<String> classifications) {
        this.classifications = classifications;
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

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
