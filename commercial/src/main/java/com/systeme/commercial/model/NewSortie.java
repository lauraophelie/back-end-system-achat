package com.systeme.commercial.model;

import java.sql.Date;

public class NewSortie {
    Date dateSortie;
    String[] idArticle;
    double[] qteSortie;
    
    public Date getDateSortie() {
        return dateSortie;
    }
    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }
    public String[] getIdArticle() {
        return idArticle;
    }
    public void setIdArticle(String[] idArticle) {
        this.idArticle = idArticle;
    }
    public double[] getQteSortie() {
        return qteSortie;
    }
    public void setQteSortie(double[] qteSortie) {
        this.qteSortie = qteSortie;
    }
}
