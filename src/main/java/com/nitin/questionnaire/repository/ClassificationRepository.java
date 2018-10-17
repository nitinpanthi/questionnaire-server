package com.nitin.questionnaire.repository;

import com.nitin.questionnaire.model.Classification;
import org.springframework.data.repository.CrudRepository;

public interface ClassificationRepository extends CrudRepository<Classification, String> {
    Classification findByName(String name);
}
