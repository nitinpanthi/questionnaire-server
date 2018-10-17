package com.nitin.questionnaire.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "question_attempt")
public class QuestionAttempt {
    @Id
    private String id = UUID.randomUUID().toString();
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "option_id", referencedColumnName = "id")
    private Option submittedAnswer;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "assessment_attempt_id", referencedColumnName = "id")
    private AssessmentAttempt assessmentAttempt;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Option getSubmittedAnswer() {
        return submittedAnswer;
    }

    public void setSubmittedAnswer(Option submittedAnswer) {
        this.submittedAnswer = submittedAnswer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AssessmentAttempt getAssessmentAttempt() {
        return assessmentAttempt;
    }

    public void setAssessmentAttempt(AssessmentAttempt assessmentAttempt) {
        this.assessmentAttempt = assessmentAttempt;
    }
}
