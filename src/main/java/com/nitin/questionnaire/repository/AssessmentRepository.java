package com.nitin.questionnaire.repository;

import com.nitin.questionnaire.model.Assessment;
import com.nitin.questionnaire.repository.custom.CustomAssessmentRepository;
import org.springframework.data.repository.CrudRepository;

public interface AssessmentRepository extends CrudRepository<Assessment, String>, CustomAssessmentRepository {
}
