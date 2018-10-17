package com.nitin.questionnaire.service;

import com.nitin.questionnaire.model.Question;
import com.nitin.questionnaire.model.QuestionAttempt;
import com.nitin.questionnaire.repository.QuestionAttemptRepository;
import com.nitin.questionnaire.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionAttemptRepository questionAttemptRepository;

    public Question getQuestion(String id) throws NoMatchingDataFoundException {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
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
        if(question.isPresent()) {
            return question.get();
        }
        throw new NoMatchingDataFoundException();
    }
}
