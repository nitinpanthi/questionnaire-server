package com.nitin.questionnaire.repository.custom;

import com.nitin.questionnaire.model.Assessment;

import java.util.Optional;

public interface CustomAssessmentRepository {
    Optional<Assessment> getAssessmentWithoutQuestions(String id);
    Optional<Assessment> getAssessmentWithQuestionSummary(String id);
}
