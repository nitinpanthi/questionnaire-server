package com.nitin.questionnaire.repository;

import com.nitin.questionnaire.model.QuestionAttempt;
import org.springframework.data.repository.CrudRepository;

public interface QuestionAttemptRepository extends CrudRepository<QuestionAttempt, String> {
}
