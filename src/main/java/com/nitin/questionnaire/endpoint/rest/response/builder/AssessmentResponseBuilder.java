package com.nitin.questionnaire.endpoint.rest.response.builder;

import com.nitin.questionnaire.endpoint.rest.response.AssessmentResponse;
import com.nitin.questionnaire.endpoint.rest.response.AssessmentSummaryResponse;
import com.nitin.questionnaire.endpoint.rest.response.AssessmentWithQuestionSummaryResponse;
import com.nitin.questionnaire.model.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssessmentResponseBuilder {

    @Autowired
    private QuestionResponseBuilder questionResponseBuilder;

    public AssessmentResponse buildAssessmentResponse(Assessment assessment) {
        AssessmentResponse response = new AssessmentResponse();
        response.setId(assessment.getId());
        response.setTitle(assessment.getTitle());
        response.setDescription(assessment.getDescription());
        response.setNumberOfquestions(assessment.getNumberOfQuestions());
        response.setQuestions(questionResponseBuilder.buildQuestionResponse(assessment.getQuestionRelations()));

        return response;
    }

    public AssessmentSummaryResponse buildAssessmentSummaryResponse(Assessment assessment) {
        AssessmentSummaryResponse response = new AssessmentSummaryResponse();
        response.setId(assessment.getId());
        response.setTitle(assessment.getTitle());
        response.setDescription(assessment.getDescription());
        response.setNumberOfQuestions(Integer.parseInt(assessment.getNumberOfQuestions()));

        return response;
    }

    public AssessmentWithQuestionSummaryResponse buildAssessmentWithQuestionSummaryResponse(Assessment assessment) {
        AssessmentWithQuestionSummaryResponse response = new AssessmentWithQuestionSummaryResponse();
        response.setId(assessment.getId());
        response.setTitle(assessment.getTitle());
        response.setDescription(assessment.getDescription());
        response.setNumberOfquestions(assessment.getNumberOfQuestions());
        response.setQuestions(questionResponseBuilder.buildQuestionSummaryResponse(assessment.getQuestionRelations()));

        return response;
    }

    public List<AssessmentSummaryResponse> buildAssessmentResponse(List<Assessment> allAssessments) {
        return allAssessments.stream().map(this::buildAssessmentSummaryResponse).collect(Collectors.toList());
    }
}
