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
        if(classification.getName() == null || classification.getName().equals("")) {
            throw new IllegalArgumentException("Cannot create a classification without a name.");
        }
        Classification savedClassification = classificationRepository.findByName(classification.getName());
        if(savedClassification != null) {
            throw new IllegalArgumentException("A classification with the same name already exists.");
        }
        return classificationRepository.save(classification);
    }

    public boolean  remove(String name) {
        try {
            Classification classification = classificationRepository.findByName(name);
            classificationRepository.deleteById(classification.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Classification> getAllClassifications() {
        return (List<Classification>) classificationRepository.findAll();
    }
}
