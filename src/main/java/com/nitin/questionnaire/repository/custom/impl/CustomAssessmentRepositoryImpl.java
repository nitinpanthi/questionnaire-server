package com.nitin.questionnaire.repository.custom.impl;

import com.nitin.questionnaire.model.Assessment;
import com.nitin.questionnaire.model.Assessment_;
import com.nitin.questionnaire.repository.custom.CustomAssessmentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Repository
public class CustomAssessmentRepositoryImpl implements CustomAssessmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Assessment> getAssessmentWithoutQuestions(String id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Assessment> query = criteriaBuilder.createQuery(Assessment.class);

        Root<Assessment> root = query.from(Assessment.class);
        Predicate condition = criteriaBuilder.equal(root.get(Assessment_.id), id);
        query.where(condition);
        query.multiselect(
                root.get(Assessment_.id),
                root.get(Assessment_.title),
                root.get(Assessment_.description),
                root.get(Assessment_.numberOfQuestions));

        TypedQuery<Assessment> typedQuery = entityManager.createQuery(query);
        return Optional.of(typedQuery.getSingleResult());
    }

    @Override
    public Optional<Assessment> getAssessmentWithQuestionSummary(String id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Assessment> query = criteriaBuilder.createQuery(Assessment.class);

        Root<Assessment> root = query.from(Assessment.class);
        Predicate condition = criteriaBuilder.equal(root.get(Assessment_.id), id);
        query.where(condition);
        query.multiselect(
                root.get(Assessment_.id),
                root.get(Assessment_.title),
                root.get(Assessment_.description),
                root.get(Assessment_.numberOfQuestions));


        TypedQuery<Assessment> typedQuery = entityManager.createQuery(query);
        return Optional.of(typedQuery.getSingleResult());
    }
}
