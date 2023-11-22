package com.systeme.commercial.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.commercial.api.APIResponse;
import com.systeme.commercial.api.ListeAPI;
import com.systeme.commercial.model.Article;
import com.systeme.commercial.service.ArticleService;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "*")
public class ArticleController {
    ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<APIResponse> findAll() {
        try {
            List<Article> articles = service.findAll();
            int count = articles.size();

            ListeAPI api = null;

            if(count == 0) {
                api = new ListeAPI("La liste est vide", null, count);
            } else {
                api = new ListeAPI(null, articles, count);
            }
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> findById(@PathVariable String id) {
        try {
            Article article = service.findById(id);
            APIResponse api = new APIResponse(null, article);

            return ResponseEntity.ok(api);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
