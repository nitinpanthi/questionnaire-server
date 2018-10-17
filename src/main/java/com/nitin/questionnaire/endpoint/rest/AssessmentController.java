package com.nitin.questionnaire.endpoint.rest;

import com.nitin.questionnaire.endpoint.rest.response.AssessmentResponse;
import com.nitin.questionnaire.endpoint.rest.response.builder.AssessmentResponseBuilder;
import com.nitin.questionnaire.endpoint.rest.response.AssessmentSummaryResponse;
import com.nitin.questionnaire.service.AssessmentService;
import com.nitin.questionnaire.service.NoMatchingDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private AssessmentResponseBuilder assessmentResponseBuilder;

    @ResponseBody
    @RequestMapping(path = "/api/assessment/{id}/summary", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<AssessmentSummaryResponse> getAssessmentSummary(@PathVariable("id") String id) throws NoMatchingDataFoundException {
        return new ResponseEntity<>(assessmentResponseBuilder.buildAssessmentSummaryResponse(assessmentService.getAssessmentSummaryWithoutQuestions(id)), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(path = "/api/assessment/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<AssessmentResponse> getAssessmentWithQuestionSummary(@PathVariable("id") String id) throws NoMatchingDataFoundException {
        return new ResponseEntity<>(assessmentResponseBuilder.buildAssessmentResponse(assessmentService.getAssessmentWithQuestionSummary(id)), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(path = "/api/admin/assessment/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<AssessmentResponse> getCompleteAssessment(@PathVariable("id") String id) throws NoMatchingDataFoundException {
        return new ResponseEntity<>(assessmentResponseBuilder.buildAssessmentResponse(assessmentService.getAssessmentForEditing(id)), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(path = "/api/user/{id}/assessment", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<AssessmentSummaryResponse>> getAllUserAssessments(@PathVariable("id") String id) throws NoMatchingDataFoundException {
        return new ResponseEntity<>(assessmentResponseBuilder.buildAssessmentResponse(assessmentService.getAllAssessments()), HttpStatus.OK);
    }
}
