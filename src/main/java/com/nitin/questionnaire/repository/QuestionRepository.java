package com.nitin.questionnaire.repository;

import com.nitin.questionnaire.model.Question;
import com.nitin.questionnaire.repository.custom.CustomQuestionRepository;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, String>, CustomQuestionRepository {
}
