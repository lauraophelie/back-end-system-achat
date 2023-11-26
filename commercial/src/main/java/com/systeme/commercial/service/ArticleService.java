package com.systeme.commercial.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.systeme.commercial.model.Article;
import com.systeme.commercial.repository.ArticleRepository;

@Service
public class ArticleService {
    ArticleRepository repository;

    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public List<Article> findAll() {
        return repository.findAll();
    }

    public Article findById(String id) {
        return repository.findById(id).orElseThrow(()-> new NoSuchElementException("Article introuvable"));
    }
}
