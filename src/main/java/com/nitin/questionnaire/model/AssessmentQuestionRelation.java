package com.nitin.questionnaire.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "assessment_question_relation")
public class AssessmentQuestionRelation implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "assessment_id", referencedColumnName = "id")
    private Assessment assessment;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;
    @Column
    private int questionIndex;

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }
}
