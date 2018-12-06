package com.nitin.questionnaire.model;

public enum DifficultyLevel {
    EASY("easy"),
    MODERATE("moderate"),
    HARD("hard"),
    VERY_HARD("very_hard");

    String difficultyLevel;

    DifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getDifficultyLevel() {
        return this.difficultyLevel;
    }
}
