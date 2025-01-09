package com.example.onlineExamQuestions.entity;

public class Metadata {
    private String category;
    private String subcategory;
    private String level;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Metadata(String category, String subcategory, String level) {
        this.category = category;
        this.subcategory = subcategory;
        this.level = level;
    }

    public Metadata() {
    }
}
