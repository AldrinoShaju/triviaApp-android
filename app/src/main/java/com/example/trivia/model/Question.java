package com.example.trivia.model;

import java.util.List;

public class Question {
    private String category;
    private String id;
    private String correctAnswer;
    private List<String> incorrectAnswers;
    private String question;
    private List<String> tag;
    private String type;
    private String difficulty;
    private List<String> regions;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "Question{" +
                "category='" + category + '\'' +
                ", id='" + id + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", incorrectAnswers=" + incorrectAnswers +
                ", question='" + question + '\'' +
                ", tag=" + tag +
                ", type='" + type + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", regions=" + regions +
                '}';
    }
}


/*{
    "category": "Music",
    "id": "622a1c387cc59eab6f950b44",
    "correctAnswer": "Nick Cave and the Bad Seeds",
    "incorrectAnswers": [
      "Air Supply",
      "The Living End",
      "Tame Impala"
    ],
    "question": "Which band includes 'Nick Cave'?",
    "tags": [
      "music"
    ],
    "type": "Multiple Choice",
    "difficulty": "easy",
    "regions": [

    ]
  },*/
