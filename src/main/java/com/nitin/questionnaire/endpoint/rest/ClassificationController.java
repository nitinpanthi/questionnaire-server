package com.nitin.questionnaire.endpoint.rest;

import com.nitin.questionnaire.endpoint.rest.request.CreateClassificationRequest;
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
    @RequestMapping(value = "/secured/api/classification", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Classification> createClassification(@RequestBody CreateClassificationRequest request) {
        Classification classification = new Classification();
        classification.setName(request.getName());
        classification.setDescription(request.getDescription());
        return new ResponseEntity<>(classificationService.create(classification), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/secured/api/classification/{name}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Boolean> removeClassification(@PathVariable("name") String name) {
        return new ResponseEntity<>(classificationService.remove(name), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/api/classifications", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Classification>> getAllClassifications() {
        return new ResponseEntity<>(classificationService.getAllClassifications(), HttpStatus.OK);
    }
}
