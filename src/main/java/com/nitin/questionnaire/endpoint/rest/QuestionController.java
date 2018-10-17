package com.nitin.questionnaire.endpoint.rest;

import com.nitin.questionnaire.model.Question;
import com.nitin.questionnaire.service.NoMatchingDataFoundException;
import com.nitin.questionnaire.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @ResponseBody
    @RequestMapping(path = "/question/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Question> getQuestion(@PathVariable("id") String id) throws NoMatchingDataFoundException {
        Question question = questionService.getQuestion(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
}
