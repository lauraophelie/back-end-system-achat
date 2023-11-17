package com.systeme.commercial.model;

import java.sql.Date;
import java.util.List;

public class BesoinGlobal {
    Date dateDebut;

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    Date dateFin;

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    List<FicheArticle> listeArticles;

    public List<FicheArticle> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(List<FicheArticle> listeArticles) {
        this.listeArticles = listeArticles;
    }

    int etat;

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
