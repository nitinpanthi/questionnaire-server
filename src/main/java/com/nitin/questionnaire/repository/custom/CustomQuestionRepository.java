package com.nitin.questionnaire.repository.custom;

import com.nitin.questionnaire.model.Question;

import java.util.Optional;

public interface CustomQuestionRepository {
    Optional<Question> getQuestionSummary(String id);
}
