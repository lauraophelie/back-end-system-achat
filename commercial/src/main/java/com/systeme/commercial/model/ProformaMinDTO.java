package com.systeme.commercial.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Tuple;

public class ProformaMinDTO {
    String idArticle;
    String nomArticle;
    Date dateProforma;
    double prixTotal;
    String nomFournisseur;
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
    public double getPrixTotal() {
        return prixTotal;
    }
    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }
    public String getNomFournisseur() {
        return nomFournisseur;
    }
    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }
    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat) {
        this.etat = etat;
    }

    public ProformaMinDTO(Tuple tuple) {
        this.idArticle = tuple.get("id_article", String.class);
        this.nomArticle = tuple.get("nomarticle", String.class);
        this.dateProforma = tuple.get("dateproforma", Date.class);
         this.prixTotal = tuple.get("prixtotal", BigDecimal.class).doubleValue();
        this.nomFournisseur = tuple.get("nomfournisseur", String.class);
        this.etat = tuple.get("etat", Integer.class);
    }

}
