package com.systeme.commercial.model;

import java.sql.Date;

public class NewProforma {
    String[] idArticle;
    int[] quantites;
    double[] prixU;
    String idFournisseurs;
    Date date;
    
    public String[] getIdArticle() {
        return idArticle;
    }
    public void setIdArticle(String[] idArticle) {
        this.idArticle = idArticle;
    }
    public int[] getQuantites() {
        return quantites;
    }
    public void setQuantites(int[] quantites) {
        this.quantites = quantites;
    }
    public double[] getPrixU() {
        return prixU;
    }
    public void setPrixU(double[] prixU) {
        this.prixU = prixU;
    }
    public String getIdFournisseurs() {
        return idFournisseurs;
    }
    public void setIdFournisseurs(String idFournisseurs) {
        this.idFournisseurs = idFournisseurs;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}
