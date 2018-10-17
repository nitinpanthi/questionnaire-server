package com.nitin.questionnaire.endpoint.rest;

import com.nitin.questionnaire.model.Assessment;
import com.nitin.questionnaire.model.Question;
import com.nitin.questionnaire.service.AssessmentService;
import com.nitin.questionnaire.service.NoMatchingDataFoundException;
import com.nitin.questionnaire.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @ResponseBody
    @RequestMapping(path = "/assessment/{id}/summary", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Assessment> getAssessmentSummary(@RequestParam("id") String id) throws NoMatchingDataFoundException {
        return new ResponseEntity<>(assessmentService.getAssessmentSummaryWithoutQuestions(id), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(path = "/assessment/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Assessment> getAssessmentWithQuestionSummary(@RequestParam("id") String id) throws NoMatchingDataFoundException {
        return new ResponseEntity<>(assessmentService.getAssessmentWithQuestionSummary(id), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(path = "/admin/assessment/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Assessment> getCompleteAssessment(@RequestParam("id") String id) throws NoMatchingDataFoundException {
        return new ResponseEntity<>(assessmentService.getAssessmentForEditing(id), HttpStatus.OK);
    }
}
