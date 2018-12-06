package com.nitin.questionnaire.endpoint.rest.response;

import com.nitin.questionnaire.model.Assessment;
import com.nitin.questionnaire.model.Question;

import java.util.List;

public class AssessmentResponse {
    private String id;
    private String title;
    private String description;
    private Integer numberOfquestions;
    private List<QuestionResponse> questions;

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

    public Integer getNumberOfquestions() {
        return numberOfquestions;
    }

    public void setNumberOfquestions(Integer numberOfquestions) {
        this.numberOfquestions = numberOfquestions;
    }

    public List<QuestionResponse> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionResponse> questions) {
        this.questions = questions;
    }
}
