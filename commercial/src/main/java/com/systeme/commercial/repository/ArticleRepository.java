package com.systeme.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.systeme.commercial.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {
    @Query(value = "SELECT * FROM Article  WHERE id LIKE :id",nativeQuery = true)
    Article getArticleById(@Param("id") String id);
}
