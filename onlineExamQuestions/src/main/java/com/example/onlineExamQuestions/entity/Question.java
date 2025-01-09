package com.example.onlineExamQuestions.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "questions_v2")
public class Question {
    @Id
    private String id;
    private String question;
    private int marks;

    private List<Choice> choices; // List of embedded choices
    private Metadata metadata; // Embedded metadata

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Question(String id, String question, int marks, List<Choice> choices, Metadata metadata) {
        this.id = id;
        this.question = question;
        this.marks = marks;
        this.choices = choices;
        this.metadata = metadata;
    }

    public Question() {
    }
}
