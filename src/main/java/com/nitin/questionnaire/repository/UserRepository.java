package com.nitin.questionnaire.repository;

import com.nitin.questionnaire.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
