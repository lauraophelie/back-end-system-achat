package com.systeme.commercial.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
    @GeneratedValue
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
    Date dateBesoin;

    public Date getDateBesoin() {
        return dateBesoin;
    }

    public void setDateBesoin(Date dateBesoin) {
        this.dateBesoin = dateBesoin;
    }

    @Column(name = "date_limite")
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

    @Column(name = "etatEmail" , columnDefinition = "integer DEFAULT 0")
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
    List<Article> listeArticles;

    public List<Article> getListeArticles() {
        return listeArticles;
    }
}
