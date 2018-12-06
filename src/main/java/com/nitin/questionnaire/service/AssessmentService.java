package com.nitin.questionnaire.service;

import com.nitin.questionnaire.model.Assessment;
import com.nitin.questionnaire.model.AssessmentQuestionRelation;
import com.nitin.questionnaire.model.Classification;
import com.nitin.questionnaire.model.Question;
import com.nitin.questionnaire.repository.AssessmentQuestionRelationshipRepository;
import com.nitin.questionnaire.repository.AssessmentRepository;
import com.nitin.questionnaire.repository.ClassificationRepository;
import com.nitin.questionnaire.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AssessmentService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private ClassificationRepository classificationRepository;

    @Autowired
    private AssessmentQuestionRelationshipRepository relationshipRepository;

    public Assessment getAssessmentForEditing(String assessmentId) throws NoMatchingDataFoundException {
        Optional<Assessment> assessment = assessmentRepository.findById(assessmentId);
        if(assessment.isPresent()) {
            return assessment.get();
        }
        throw new NoMatchingDataFoundException();
    }

    public Assessment getAssessmentSummaryWithoutQuestions(String assessmentId) throws NoMatchingDataFoundException {
        Optional<Assessment> assessment = assessmentRepository.getAssessmentWithoutQuestions(assessmentId);
        if(assessment.isPresent()) {
            return assessment.get();
        }
        throw new NoMatchingDataFoundException();
    }

    public Assessment getAssessmentWithQuestionSummary(String assessmentId) throws NoMatchingDataFoundException {
        Optional<Assessment> assessment = assessmentRepository.getAssessmentWithQuestionSummary(assessmentId);
        if(assessment.isPresent()) {
            return assessment.get();
        }
        throw new NoMatchingDataFoundException();
    }

    public List<Assessment> getAllAssessments() {
        return (List<Assessment>) assessmentRepository.findAll();
    }

    public Assessment createAssessment(Assessment assessment, List<String> classifications) {
        if(!classifications.isEmpty()) {
            List<Classification> foundClassifications = (List<Classification>) classificationRepository.findAllById(classifications);
            assessment.setClassifications(foundClassifications);
        }
        return assessmentRepository.save(assessment);
    }

    @Transactional
    public String addQuestionToAssessment(String assessmentId, String questionId) throws Exception {
        Optional<Question> questionHolder =  questionRepository.findById(questionId);
        Optional<Assessment> assessmentHolder = assessmentRepository.findById(assessmentId);

        if(questionHolder.isPresent() && assessmentHolder.isPresent()) {
            Question question = questionHolder.get();
            Assessment assessment = assessmentHolder.get();

            AssessmentQuestionRelation relation = new AssessmentQuestionRelation();
            relation.setQuestion(question);
            relation.setAssessment(assessment);
            relation.setQuestionIndex(assessment.getQuestionRelations().size());
            relation = relationshipRepository.save(relation);

            question.getAssessmentQuestionRelations().add(relation);
            questionRepository.save(question);

            assessment.getQuestionRelations().add(relation);
            assessment.getClassifications().addAll(question.getClassifications());
            assessmentRepository.save(assessment);

            return relation.getId();
        }
        throw new Exception("Could not add the question to assessment");
    }
}
