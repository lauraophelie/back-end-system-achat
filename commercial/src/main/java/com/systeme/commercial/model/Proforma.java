package com.systeme.commercial.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proforma")
public class Proforma {
    @Id
    @Column(name = "id_article")
    String idArticle;

    @Column(name = "quantite")
    int quantite;

    @Column(name = "prixUnitaire")
    double prixU;

    @Column(name = "id_fournisseur")
    String idFournisseur;

    @Column(name = "dateProforma")
    Date dateProforma;

    // @ManyToOne
    // @JoinColumn(name = "id_article")
    // Article article;

    // @ManyToOne
    // @JoinColumn(name = "id_fournisseur")
    // Fournisseur fournisseur;

    public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixU() {
        return prixU;
    }

    public void setPrixU(double prixU) {
        this.prixU = prixU;
    }

    public String getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(String idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public Date getDateProforma() {
        return dateProforma;
    }

    public void setDateProforma(Date dateProforma) {
        this.dateProforma = dateProforma;
    }

    // public Article getArticle() {
    //     return article;
    // }

    // public void setArticle(Article article) {
    //     this.article = article;
    // }

    // public Fournisseur getFournisseur() {
    //     return fournisseur;
    // }

    // public void setFournisseur(Fournisseur fournisseur) {
    //     this.fournisseur = fournisseur;
    // }
}
