package com.nitin.questionnaire.endpoint.rest;

import com.nitin.questionnaire.endpoint.rest.request.assessment.AssessmentCreationRequest;
import com.nitin.questionnaire.endpoint.rest.request.assessment.QuestionCreationRequest;
import com.nitin.questionnaire.model.Assessment;
import com.nitin.questionnaire.model.Question;
import com.nitin.questionnaire.service.AssessmentService;
import com.nitin.questionnaire.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;

@RestController
public class AssessmentCreationController {

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private QuestionService questionService;

    @ResponseBody
    @RequestMapping(
            path = "/secured/api/assessment",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<String> createAssessment(@RequestBody  AssessmentCreationRequest request) {
        Assessment assessment = new Assessment();

        assessment.setTitle(request.getName());
        assessment.setDescription(request.getDescription());
        assessment.setCreatedOn(LocalDate.now());
        assessment.setLastUpdatedOn(request.getLastUpdateDate());
        assessment.setCreatedBy(request.getCreatedBy());
        assessment.setLocale(request.getLocale());
        assessment.setDifficultyLevel(request.getDifficultyLevel());

        return new ResponseEntity<>(assessmentService.createAssessment(assessment, request.getClassifications()).getId(), HttpStatus.OK);
    }

    @RequestMapping(
            path = "/secured/api/relation/assessment/{assessmentId}/question/{questionId}",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<String> addQuestionToAssessment(@PathVariable("assessmentId") String assessmentId,@PathVariable("questionId") String questionId) throws Exception {
        return new ResponseEntity<>(assessmentService.addQuestionToAssessment(assessmentId, questionId), HttpStatus.OK);
    }

    @RequestMapping(
            path = "/secured/api/question",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<String> createQuestion(@RequestBody QuestionCreationRequest request) {
        Question question = new Question();

        question.setCreatedBy(request.getCreatedBy());
        question.setCreatedOn(LocalDate.now());
        question.setLocale(request.getLocale());
        question.setDifficultyLevel(request.getDifficultyLevel());
        question.setDescription(request.getDescription());

        Question savedQuestion = questionService.createQuestion(question, request.getOptions(), request.getCorrectAnswers(), request.getClassifications());

        return new ResponseEntity<>(savedQuestion.getId(), HttpStatus.OK);
    }
}
