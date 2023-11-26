package com.systeme.commercial.model;

import java.sql.Date;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "vue_prix_minimum_par_article_et_date")
@Immutable
public class ProformaMin {
    @Id
    @Column(name = "id_article")
    String idArticle;

    @Column(name = "nomarticle")
    String nomArticle;

    @Column(name = "dateproforma")
    Date dateProforma;

    @Column(name = "prixtotal")
    double prixtotal;

    @Column(name = "nomfournisseur")
    String nomfournisseur;

    @Column(name = "etat")
    int etat;

    public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public Date getDateProforma() {
        return dateProforma;
    }

    public void setDateProforma(Date dateProforma) {
        this.dateProforma = dateProforma;
    }

    public double getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(double prixtotal) {
        this.prixtotal = prixtotal;
    }

    public String getNomfournisseur() {
        return nomfournisseur;
    }

    public void setNomfournisseur(String nomfournisseur) {
        this.nomfournisseur = nomfournisseur;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
