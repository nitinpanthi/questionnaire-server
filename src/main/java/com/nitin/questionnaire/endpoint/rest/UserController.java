package com.nitin.questionnaire.endpoint.rest;

import com.nitin.questionnaire.endpoint.rest.request.assessment.UserCreationRequest;
import com.nitin.questionnaire.model.User;
import com.nitin.questionnaire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @ResponseBody
    @RequestMapping(
            path = "/secured/api/user",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<User> createUser(UserCreationRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        return new ResponseEntity<>(service.save(user), HttpStatus.OK);
    }
}
