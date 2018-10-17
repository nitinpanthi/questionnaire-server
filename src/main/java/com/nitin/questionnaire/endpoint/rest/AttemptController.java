package com.nitin.questionnaire.endpoint.rest;

import com.nitin.questionnaire.model.AssessmentAttempt;
import com.nitin.questionnaire.model.QuestionAttempt;
import com.nitin.questionnaire.service.AttemptService;
import com.nitin.questionnaire.service.NoMatchingDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AttemptController {
    @Autowired
    private AttemptService attemptService;

    @ResponseBody
    @RequestMapping(path = "/question/action/attempt", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<QuestionAttempt> submitQuestionResponse(@RequestBody QuestionAttempt questionAttempt) {
        return new ResponseEntity<>(attemptService.submitQuestionResponse(questionAttempt), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(path = "/assessment/{id}/action/attempt", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<AssessmentAttempt> prepareAssessmentForAttempt(@PathVariable("id") String assessmentId) throws NoMatchingDataFoundException {
        return new ResponseEntity<>(attemptService.prepareAssessment(assessmentId), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(path = "/assessment/attempt/{id}/action/start", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<AssessmentAttempt> startAssessment(@PathVariable("id") String attemptId) throws NoMatchingDataFoundException {
        return new ResponseEntity<>(attemptService.startAssessment(attemptId), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(path = "/assessment/attempt/{id}/action/submit", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<AssessmentAttempt> submitEntireAssessment(@PathVariable("id") String attemptId) throws NoMatchingDataFoundException {
        return new ResponseEntity<>(attemptService.submitAssessment(attemptId), HttpStatus.OK);
    }
}
