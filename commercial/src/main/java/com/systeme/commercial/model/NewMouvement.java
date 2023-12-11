package com.systeme.commercial.model;

import java.sql.Date;

import jakarta.persistence.Column;

public class NewMouvement {
    int idEntree;

    Date dateget_entree;

    double qtein_entree;

    int idSortie;

    Date date_sortie;

    double qtea_sortir;

    double restefordate_entree;

    double restea_sortir;

    double prixEntree;

    double qtesortie_initiale;

    String idArticle;

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
