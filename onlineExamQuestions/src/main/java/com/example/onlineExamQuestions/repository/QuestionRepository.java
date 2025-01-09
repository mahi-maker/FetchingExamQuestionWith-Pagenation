package com.example.onlineExamQuestions.repository;

import com.example.onlineExamQuestions.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
    // Find questions by category (no subcategory or level)
    Page<Question> findByMetadataCategory(String category, Pageable pageable);
}
