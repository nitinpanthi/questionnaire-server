package com.nitin.questionnaire.endpoint.rest.response.builder;

import com.nitin.questionnaire.endpoint.rest.response.OptionResponse;
import com.nitin.questionnaire.model.Option;
import com.nitin.questionnaire.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptionResponseBuilder {
    public OptionResponse buildOptionResponse(Option option) {
        OptionResponse response = new OptionResponse();
        response.setId(option.getId());
        response.setDescription(option.getDescription());
        return response;
    }

    public List<OptionResponse> buildOptionResponse(List<Option> options) {
        return options.stream().map(this::buildOptionResponse).collect(Collectors.toList());
    }
}
