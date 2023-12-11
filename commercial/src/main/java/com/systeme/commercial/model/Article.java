package com.systeme.commercial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_seq")
    @SequenceGenerator(name = "article_seq", sequenceName = "article_id_seq", allocationSize = 1)
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

    // @ManyToOne
    // @JoinColumn(name = "categorie")
    // Categorie categorie;

    // public Categorie getCategorie() {
    //     return categorie;
    // }

    // public void setCategorie(Categorie categorie) {
    //     this.categorie = categorie;
    // }

    @Column(name = "typearticle")
    int typeArticle;
    
    public int getTypeArticle() {
        return typeArticle;
    }

    // @Column(name = "idunite")
    // int idUnite;

    // public int getIdUnite() {
    //     return idUnite;
    // }

    // public void setIdUnite(int idUnite) {
    //     this.idUnite = idUnite;
    // }

    public void setTypeArticle(int typeArticle) {
        this.typeArticle = typeArticle;
    }

    public Article() {}
    public Article(String nomArticle, Categorie categorie) {
        this.setNomArticle(nomArticle);
        // this.setCategorie(categorie);
        
    }
    public Article(String id, String nomArticle, Categorie categorie) {
        this.setId(id);
        this.setNomArticle(nomArticle);
        // this.setCategorie(categorie);
    }
}
