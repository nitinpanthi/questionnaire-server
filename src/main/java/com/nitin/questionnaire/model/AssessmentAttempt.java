package com.nitin.questionnaire.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "assessment_attempt")
public class AssessmentAttempt {
    @Id
    private String id = UUID.randomUUID().toString();
    @Column
    private LocalDate startTime;
    @Column
    private LocalDate endTime;
    @Column
    @Enumerated(value = EnumType.STRING)
    private Status status = Status.NOT_STARTED;
    @ManyToOne
    @JoinColumn
    private Assessment assessment;
    @OneToMany(mappedBy = "assessmentAttempt" )
    private List<QuestionAttempt> questionAttempts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public List<QuestionAttempt> getQuestionAttempts() {
        return questionAttempts;
    }

    public void setQuestionAttempts(List<QuestionAttempt> questionAttempts) {
        this.questionAttempts = questionAttempts;
    }
}
