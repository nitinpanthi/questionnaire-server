package com.nitin.questionnaire.service;

import com.nitin.questionnaire.model.Classification;
import com.nitin.questionnaire.repository.ClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationService {

    @Autowired
    private ClassificationRepository classificationRepository;

    public Classification create(Classification classification) {
        return classificationRepository.save(classification);
    }

    public boolean remove(Classification classification) {
        try {
            classificationRepository.deleteById(classification.getId());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Classification> getAllClassifications() {
        return (List<Classification>) classificationRepository.findAll();
    }
}
