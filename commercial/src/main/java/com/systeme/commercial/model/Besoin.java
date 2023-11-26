package com.systeme.commercial.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "besoin")
public class Besoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "id_service")
    String idService;


    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    // @ManyToOne
    // @JoinColumn(name = "id_service")
    // Service serviceConcerne;

    // public Service getServiceConcerne() {
    //     return serviceConcerne;
    // }

    // public void setServiceConcerne(Service serviceConcerne) {
    //     this.serviceConcerne = serviceConcerne;
    // }

    @Column(name = "date_besoin", columnDefinition = "DATE DEFAULT now()")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    Date dateBesoin;

    public Date getDateBesoin() {
        return dateBesoin;
    }

    public void setDateBesoin(Date dateBesoin) {
        this.dateBesoin = dateBesoin;
    }

    @Column(name = "date_limite")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    Date dateLimite;

    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }

    @Column(name ="etat", columnDefinition = "integer DEFAULT 0")
    int etat;

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Column(name = "etatemail" , columnDefinition = "integer DEFAULT 0")
    int etatEmail;

    public int getEtatEmail() {
        return etatEmail;
    }

    public void setEtatEmail(int etatEmail) {
        this.etatEmail = etatEmail;
    }

    @ManyToMany
    @JoinTable(
        name = "besoin_article",
        joinColumns = @JoinColumn(name = "id_besoin"),
        inverseJoinColumns = @JoinColumn(name = "id_article")
    )
    List<BesoinArticle> listeArticles;

    public List<BesoinArticle> getListeArticles() {
        return listeArticles;
    }
}
