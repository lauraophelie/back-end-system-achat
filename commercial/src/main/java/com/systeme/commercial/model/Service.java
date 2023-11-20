package com.systeme.commercial.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @Column(name = "id", columnDefinition = "varchar(8) DEFAULT CONCAT('SER', nextval('service_id_seq')) NOT NULL")
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "nom_service")
    String nomService;

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    @ManyToMany
    @JoinTable(
        name = "article_service",
        joinColumns = @JoinColumn(name = "id_service"),
        inverseJoinColumns = @JoinColumn(name = "id_article")
    )
    List<Article> listeArticles;

    public List<Article> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(List<Article> listeArticles) {
        this.listeArticles = listeArticles;
    }

    public Service() {}
    public Service(String id, String nomService) {
        this.setId(id);
        this.setNomService(nomService);
    }
}
