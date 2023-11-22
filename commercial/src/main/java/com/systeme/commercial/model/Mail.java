package com.systeme.commercial.model;

import java.sql.Date;
import java.util.List;

public class Mail {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    Fournisseur fournisseur;

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    String objet;

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    List<FicheArticle> listeArticles;

    public List<FicheArticle> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(List<FicheArticle> listeArticles) {
        this.listeArticles = listeArticles;
    }

    Entreprise entreprise;

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    Date dateEnvoi;

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }
}
