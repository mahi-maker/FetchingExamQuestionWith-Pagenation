package com.example.onlineExamQuestions.controller;

import com.example.onlineExamQuestions.dto.PageResponse;
import com.example.onlineExamQuestions.entity.Question;
import com.example.onlineExamQuestions.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;


    // Endpoint to get questions across multiple pages
    @GetMapping("/techstack/{category}")
    public ResponseEntity<?> getQuestionsByCategoryForSinglePage(
            @PathVariable String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size) {

        // Validate page and size parameters
        if (page < 0 || size <= 0) {
            return ResponseEntity.badRequest().body("Page index must be >= 0 and size must be > 0.");
        }


        PageResponse response = questionService.getQuestionsByCategoryWithSinglePage(category, page, size);

//        if (response == null) {
//            return ResponseEntity.noContent().build();
//        }
        // Handle case when no questions are found or invalid category
        if (response == null || response.getQuestions().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No questions found for the specified category and page.");
        }

        return ResponseEntity.ok(response);
    }
}