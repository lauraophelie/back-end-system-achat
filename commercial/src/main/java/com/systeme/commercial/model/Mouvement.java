package com.systeme.commercial.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mouvement")
public class Mouvement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmouvement")
    int idMouvement;

    @Column(name = "identree")
    int idEntree;

    @Column(name = "dateget_entree")
    Date dateget_entree;

    @Column(name = "qtein_entree")
    double qtein_entree;

    @Column(name = "idsortie")
    int idSortie;

    @Column(name = "date_sortie")
    Date date_sortie;

    @Column(name = "qtea_sortir")
    double qtea_sortir;

    @Column(name = "restefordate_entree")
    double restefordate_entree;

    @Column(name = "restea_sortir")
    double restea_sortir;

    @Column(name = "prixentree")
    double prixEntree;

    @Column(name = "qtesortie_initiale")
    double qtesortie_initiale;

    @Column(name = "idarticle")
    String idArticle;

    public int getIdMouvement() {
        return idMouvement;
    }

    public void setIdMouvement(int idMouvement) {
        this.idMouvement = idMouvement;
    }

    public int getIdEntree() {
        return idEntree;
    }

    public void setIdEntree(int idEntree) {
        this.idEntree = idEntree;
    }

    public Date getDateget_entree() {
        return dateget_entree;
    }

    public void setDateget_entree(Date dateget_entree) {
        this.dateget_entree = dateget_entree;
    }

    public double getQtein_entree() {
        return qtein_entree;
    }

    public void setQtein_entree(double qtein_entree) {
        this.qtein_entree = qtein_entree;
    }

    public int getIdSortie() {
        return idSortie;
    }

    public void setIdSortie(int idSortie) {
        this.idSortie = idSortie;
    }

    public Date getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
    }

    public double getQtea_sortir() {
        return qtea_sortir;
    }

    public void setQtea_sortir(double qtea_sortir) {
        this.qtea_sortir = qtea_sortir;
    }

    public double getRestefordate_entree() {
        return restefordate_entree;
    }

    public void setRestefordate_entree(double restefordate_entree) {
        this.restefordate_entree = restefordate_entree;
    }

    public double getRestea_sortir() {
        return restea_sortir;
    }

    public void setRestea_sortir(double restea_sortir) {
        this.restea_sortir = restea_sortir;
    }

    public double getPrixEntree() {
        return prixEntree;
    }

    public void setPrixEntree(double prixEntree) {
        this.prixEntree = prixEntree;
    }

    public double getQtesortie_initiale() {
        return qtesortie_initiale;
    }

    public void setQtesortie_initiale(double qtesortie_initiale) {
        this.qtesortie_initiale = qtesortie_initiale;
    }

    public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }
}
