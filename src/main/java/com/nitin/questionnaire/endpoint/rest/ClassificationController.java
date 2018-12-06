package com.nitin.questionnaire.endpoint.rest;

import com.nitin.questionnaire.model.Classification;
import com.nitin.questionnaire.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @ResponseBody
    @RequestMapping(value = "/api/classification/{name}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Classification> createClassification(@PathVariable("name") String classificationName) {
        Classification classification = new Classification();
        classification.setName(classificationName);
        return new ResponseEntity<>(classificationService.create(classification), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/api/classification/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Boolean> removeClassification(@PathVariable("id") String classificationId) {
        Classification classification = new Classification();
        classification.setId(classificationId);
        return new ResponseEntity<>(classificationService.remove(classification), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/api/classifications", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Classification>> getAllClassifications() {
        return new ResponseEntity<>(classificationService.getAllClassifications(), HttpStatus.OK);
    }
}
