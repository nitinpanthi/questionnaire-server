package com.nitin.questionnaire.service;

import com.nitin.questionnaire.model.Assessment;
import com.nitin.questionnaire.model.AssessmentAttempt;
import com.nitin.questionnaire.model.QuestionAttempt;
import com.nitin.questionnaire.model.Status;
import com.nitin.questionnaire.repository.AssessmentAttemptRepository;
import com.nitin.questionnaire.repository.AssessmentRepository;
import com.nitin.questionnaire.repository.QuestionAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class AttemptService {

    @Autowired
    private AssessmentAttemptRepository assessmentAttemptRepository;

    @Autowired
    private QuestionAttemptRepository questionAttemptRepository;

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Transactional
    public AssessmentAttempt prepareAssessment(String assessmentId) throws NoMatchingDataFoundException {
        Optional<Assessment> assessment = assessmentRepository.findById(assessmentId);
        if(assessment.isPresent()) {
            AssessmentAttempt attempt = new AssessmentAttempt();
            attempt.setAssessment(assessment.get());
            return assessmentAttemptRepository.save(attempt);
        }
        throw new NoMatchingDataFoundException();
    }

    @Transactional
    public AssessmentAttempt startAssessment(String attemptId) throws NoMatchingDataFoundException {
        Optional<AssessmentAttempt> attemptHolder = assessmentAttemptRepository.findById(attemptId);
        if(attemptHolder.isPresent()) {
            AssessmentAttempt attempt = attemptHolder.get();
            attempt.setStartTime(LocalDate.now());
            attempt.setStatus(Status.IN_PROGRESS);
            return assessmentAttemptRepository.save(attempt);
        }
        throw new NoMatchingDataFoundException();
    }

    @Transactional
    public AssessmentAttempt submitAssessment(String attemptId) throws NoMatchingDataFoundException {
        Optional<AssessmentAttempt> attemptHolder = assessmentAttemptRepository.findById(attemptId);
        if(attemptHolder.isPresent()) {
            AssessmentAttempt attempt = attemptHolder.get();
            attempt.setEndTime(LocalDate.now());
            attempt.setStatus(Status.COMPLETED);
            return assessmentAttemptRepository.save(attempt);
        }
        throw new NoMatchingDataFoundException();
    }

    @Transactional
    public QuestionAttempt submitQuestionResponse(QuestionAttempt attempt) {
        return questionAttemptRepository.save(attempt);
    }
}
