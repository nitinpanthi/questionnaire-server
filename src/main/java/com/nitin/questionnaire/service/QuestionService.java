package com.nitin.questionnaire.service;

import com.nitin.questionnaire.endpoint.rest.request.assessment.QuestionCreationRequest;
import com.nitin.questionnaire.model.Classification;
import com.nitin.questionnaire.model.Option;
import com.nitin.questionnaire.model.Question;
import com.nitin.questionnaire.repository.ClassificationRepository;
import com.nitin.questionnaire.repository.OptionRepository;
import com.nitin.questionnaire.repository.QuestionAttemptRepository;
import com.nitin.questionnaire.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private ClassificationRepository classificationRepository;


    @Autowired
    private QuestionAttemptRepository questionAttemptRepository;

    public Question getQuestion(String id) throws NoMatchingDataFoundException {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        }
        throw new NoMatchingDataFoundException();
    }

    @Transactional
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question getQuestionSummary(String id) throws NoMatchingDataFoundException {
        Optional<Question> question = questionRepository.getQuestionSummary(id);
        if (question.isPresent()) {
            return question.get();
        }
        throw new NoMatchingDataFoundException();
    }

    @Transactional
    public Question createQuestion(Question question, Map<Integer, String> options, List<Integer> correctAnswers, List<String> classificationIds) {

        if(!classificationIds.isEmpty()) {
            List<Classification> foundClassifications = (List<Classification>) classificationRepository.findAllById(classificationIds);
            question.setClassifications(foundClassifications);
        }

        Question savedQuestion = questionRepository.save(question);

        for (Map.Entry<Integer, String> entry : options.entrySet()) {
            Option option = optionRepository.save(new Option(entry.getValue(), question));
            if (correctAnswers.contains(entry.getKey())) {
                savedQuestion.getCorrectAnswers().add(option);
            }
            savedQuestion.getOptions().add(option);
        }

        return questionRepository.save(question);
    }
}