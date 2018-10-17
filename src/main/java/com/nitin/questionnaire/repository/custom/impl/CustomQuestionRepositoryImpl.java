package com.nitin.questionnaire.repository.custom.impl;

import com.nitin.questionnaire.model.Assessment;
import com.nitin.questionnaire.model.Assessment_;
import com.nitin.questionnaire.model.Question;
import com.nitin.questionnaire.model.Question_;
import com.nitin.questionnaire.repository.custom.CustomQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class CustomQuestionRepositoryImpl implements CustomQuestionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Question> getQuestionSummary(String id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Question> query = criteriaBuilder.createQuery(Question.class);

        Root<Question> root = query.from(Question.class);
        Predicate condition = criteriaBuilder.equal(root.get(Question_.id), id);
        query.where(condition);
        query.multiselect(
                root.get(Question_.id),
                root.get(Question_.title),
                root.get(Question_.description),
                root.get(Question_.weightage));

        TypedQuery<Question> typedQuery = entityManager.createQuery(query);
        return Optional.of(typedQuery.getSingleResult());
    }
}
