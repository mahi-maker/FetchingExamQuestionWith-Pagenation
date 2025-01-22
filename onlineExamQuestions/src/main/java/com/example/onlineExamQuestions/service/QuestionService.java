package com.example.onlineExamQuestions.service;

import com.example.onlineExamQuestions.dto.PageResponse;
import com.example.onlineExamQuestions.entity.Question;
import com.example.onlineExamQuestions.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {
//    @Autowired
//    private QuestionRepository questionRepository;
//
//
//    private static final List<String> PAGE_NAMES = List.of("Aptitude/Reasoning", "Backend", "FrontEnd", "Database");
//
//    public PageResponse getQuestionsByCategoryWithSinglePage(String category, int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Question> questionPage = questionRepository.findByMetadataCategory(category, pageable);
//
//        if (questionPage.isEmpty()) {
//            return null; // Return null if no questions are found
//        }
//
//        String pageName = getPageName(page);
//        return new PageResponse(pageName, questionPage.getContent());
//    }
//
//    private String getPageName(int page) {
//        return page < PAGE_NAMES.size() ? PAGE_NAMES.get(page) : "Unknown Page";
//    }
//}


    // Category-to-page names mapping
    private static final Map<String, List<String>> CATEGORY_PAGE_NAMES = Map.of(
            "DataScience", List.of("Aptitude & Reasoning", "Advanced Excel", "PowerBi"),
            "Embedded", List.of("Aptitude & Reasoning", "ARM", "C Programming", "Linux"),
            "Java", List.of("Aptitude & Reasoning", "Core Java", "Hibernate", "MySQL", "FrontEnd", "Collections", "MultiThreading", "JDBC")
    );

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public PageResponse getQuestionsByCategoryWithSinglePage(String category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Question> questionPage = questionRepository.findByMetadataCategory(category, pageable);

        if (questionPage.isEmpty()) {
            return null; // Return null if no questions are found
        }

        String pageName = getPageNameByCategory(category, page);
        return new PageResponse(pageName, questionPage.getContent());
    }

    private String getPageNameByCategory(String category, int page) {
        // Get the list of page names for the given category
        List<String> pageNames = CATEGORY_PAGE_NAMES.getOrDefault(category, List.of("Unknown Category"));

        // Return the page name based on the page index, or "Unknown Page" if out of range
        return page < pageNames.size() ? pageNames.get(page) : "Unknown Page";
    }
}