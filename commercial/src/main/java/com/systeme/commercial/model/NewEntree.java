package com.systeme.commercial.model;

import java.sql.Date;

public class NewEntree {
    Date dateEntree;
    String[] idArticle;
    double[] prix;
    double[] qteEntree;
    
    public Date getDateEntree() {
        return dateEntree;
    }
    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }
    public String[] getIdArticle() {
        return idArticle;
    }
    public void setIdArticle(String[] idArticle) {
        this.idArticle = idArticle;
    }
    public double[] getPrix() {
        return prix;
    }
    public void setPrix(double[] prix) {
        this.prix = prix;
    }
    public double[] getQteEntree() {
        return qteEntree;
    }
    public void setQteEntree(double[] qteEntree) {
        this.qteEntree = qteEntree;
    }
}
