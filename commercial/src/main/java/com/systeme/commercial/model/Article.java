package com.systeme.commercial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "categorie")
    Categorie categorie;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Article() {}
    public Article(String nomArticle, Categorie categorie) {
        this.setNomArticle(nomArticle);
        this.setCategorie(categorie);
    }
    public Article(String id, String nomArticle, Categorie categorie) {
        this.setId(id);
        this.setNomArticle(nomArticle);
        this.setCategorie(categorie);
    }
}
