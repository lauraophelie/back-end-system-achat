package com.systeme.commercial.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "id", columnDefinition = "varchar(8) DEFAULT CONCAT('BES', nextval('besoin_id_seq')) NOT NULL")
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @ManyToOne
    @JoinColumn(name = "id_service")
    Service serviceConcerne;

    public Service getServiceConcerne() {
        return serviceConcerne;
    }

    public void setServiceConcerne(Service serviceConcerne) {
        this.serviceConcerne = serviceConcerne;
    }

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
