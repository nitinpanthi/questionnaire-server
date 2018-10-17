package com.nitin.questionnaire.endpoint.rest.response.builder;

import com.nitin.questionnaire.endpoint.rest.response.QuestionResponse;
import com.nitin.questionnaire.endpoint.rest.response.QuestionSummaryResponse;
import com.nitin.questionnaire.model.AssessmentQuestionRelation;
import com.nitin.questionnaire.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionResponseBuilder {
    @Autowired
    private OptionResponseBuilder optionResponseBuilder;

    public QuestionResponse buildQuestionResponse(Question question) {
        QuestionResponse response = new QuestionResponse();
        response.setId(question.getId());
        response.setTitle(question.getTitle());
        response.setDescription(question.getDescription());
        response.setMarks(question.getWeightage());
        response.setOptions(optionResponseBuilder.buildOptionResponse(question.getOptions()));
        return response;
    }

    public QuestionResponse buildQuestionResponse(AssessmentQuestionRelation assessmentQuestionRelation) {
        return buildQuestionResponse(assessmentQuestionRelation.getQuestion());
    }

    public List<QuestionResponse> buildQuestionResponse(List<AssessmentQuestionRelation> options) {
        return options.stream().map(this::buildQuestionResponse).collect(Collectors.toList());
    }

    public QuestionSummaryResponse buildQuestionSummaryResponse(Question question) {
        QuestionSummaryResponse response = new QuestionSummaryResponse();
        response.setId(question.getId());
        response.setTitle(question.getTitle());
        response.setMarks(question.getWeightage());
        return response;
    }

    public QuestionSummaryResponse buildQuestionSummaryResponse(AssessmentQuestionRelation assessmentQuestionRelation) {
        return buildQuestionSummaryResponse(assessmentQuestionRelation.getQuestion());
    }

    public List<QuestionSummaryResponse> buildQuestionSummaryResponse(List<AssessmentQuestionRelation> options) {
        return options.stream().map(this::buildQuestionSummaryResponse).collect(Collectors.toList());
    }
}
