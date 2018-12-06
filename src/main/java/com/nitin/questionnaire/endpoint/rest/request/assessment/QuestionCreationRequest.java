package com.nitin.questionnaire.endpoint.rest.request.assessment;

import com.nitin.questionnaire.model.DifficultyLevel;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class QuestionCreationRequest {
    private String description;
    private List<String> classifications;
    private Map<Integer, String> options;
    private List<Integer> correctAnswers;
    private String createdBy;
    private DifficultyLevel difficultyLevel;
    private Locale locale;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Integer, String> getOptions() {
        return options;
    }

    public void setOptions(Map<Integer, String> options) {
        this.options = options;
    }

    public List<Integer> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(List<Integer> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

    public List<String> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<String> classifications) {
        this.classifications = classifications;
    }
}
