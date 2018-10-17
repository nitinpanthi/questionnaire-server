package com.nitin.questionnaire.service;

import com.nitin.questionnaire.model.Assessment;
import com.nitin.questionnaire.repository.AssessmentRepository;
import com.nitin.questionnaire.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AssessmentRepository assessmentRepository;

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
}
