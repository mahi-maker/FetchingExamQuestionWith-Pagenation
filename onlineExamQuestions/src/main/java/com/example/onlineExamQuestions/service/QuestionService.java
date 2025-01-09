package com.example.onlineExamQuestions.service;

import com.example.onlineExamQuestions.entity.Question;
import com.example.onlineExamQuestions.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private  QuestionRepository questionRepository;


   public Page<Question> getQuestionsByCategory(String category, int page, int size) {
    Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
    return questionRepository.findByMetadataCategory(category, pageable);
   }

}
