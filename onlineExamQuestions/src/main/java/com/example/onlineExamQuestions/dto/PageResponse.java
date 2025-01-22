package com.example.onlineExamQuestions.dto;

import com.example.onlineExamQuestions.entity.Question;

import java.util.List;

public class PageResponse {
    private String pageName;
    private List<Question> questions;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public PageResponse(String pageName, List<Question> questions) {
        this.pageName = pageName;
        this.questions = questions;
    }
}
