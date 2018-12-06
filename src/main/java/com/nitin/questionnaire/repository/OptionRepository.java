package com.nitin.questionnaire.repository;

import com.nitin.questionnaire.model.Option;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, String> {
}
