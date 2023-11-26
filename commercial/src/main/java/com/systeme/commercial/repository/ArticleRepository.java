package com.systeme.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systeme.commercial.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {
    
}
