package com.nitin.questionnaire.endpoint.rest.request.assessment;

public class QuestionAdditionRequest {
    private String assessment;
    private String question;

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
