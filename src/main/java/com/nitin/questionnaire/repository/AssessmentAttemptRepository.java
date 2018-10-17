package com.nitin.questionnaire.repository;

import com.nitin.questionnaire.model.AssessmentAttempt;
import com.nitin.questionnaire.repository.custom.CustomAssessmentRepository;
import org.springframework.data.repository.CrudRepository;

public interface AssessmentAttemptRepository extends CrudRepository<AssessmentAttempt, String> {
}
