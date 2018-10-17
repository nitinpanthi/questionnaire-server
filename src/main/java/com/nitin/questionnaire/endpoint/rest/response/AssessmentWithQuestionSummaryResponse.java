package com.nitin.questionnaire.endpoint.rest.response;

import java.util.List;

public class AssessmentWithQuestionSummaryResponse {
    private String id;
    private String title;
    private String description;
    private String numberOfquestions;
    private List<QuestionSummaryResponse> questions;

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

    public String getNumberOfquestions() {
        return numberOfquestions;
    }

    public void setNumberOfquestions(String numberOfquestions) {
        this.numberOfquestions = numberOfquestions;
    }

    public List<QuestionSummaryResponse> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionSummaryResponse> questions) {
        this.questions = questions;
    }
}
