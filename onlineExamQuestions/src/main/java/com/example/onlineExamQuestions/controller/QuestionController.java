package com.example.onlineExamQuestions.controller;

import com.example.onlineExamQuestions.entity.Question;
import com.example.onlineExamQuestions.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private  QuestionService questionService;



    @GetMapping("/techstack/{category}")
    public ResponseEntity<Page<Question>> getQuestions(
            @PathVariable String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size) {

        Page<Question> questions = questionService.getQuestionsByCategory(category,  page, size);
        return ResponseEntity.ok(questions);
    }

}
