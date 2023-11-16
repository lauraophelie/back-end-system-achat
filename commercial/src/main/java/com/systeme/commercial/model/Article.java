package com.systeme.commercial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @Column(name = "id", columnDefinition = "varchar(8) DEFAULT CONCAT('ART', nextval('article_id_seq')) NOT NULL")
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "nom")
    String nomArticle;

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public Article() {}
    public Article(String id, String nomArticle) {
        this.setId(id);
        this.setNomArticle(nomArticle);
    }
}
