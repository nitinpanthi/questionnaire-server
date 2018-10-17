package com.nitin.questionnaire.endpoint.rest.response;

import java.util.List;

public class QuestionSummaryResponse {
    private String id;
    private String title;
    private int marks;

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

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
