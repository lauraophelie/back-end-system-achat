package com.systeme.commercial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorie_article")
public class Categorie {
    @Id
    @Column(name = "id", columnDefinition = "varchar(8) DEFAULT CONCAT('CAT', nextval('categorie_article_id_seq')) NOT NULL")
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "nom_categorie")
    String nomCategorie;

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
}
