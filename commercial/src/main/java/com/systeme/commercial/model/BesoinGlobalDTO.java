package com.systeme.commercial.model;

import jakarta.persistence.Tuple;

public class BesoinGlobalDTO {
    int semaine;
    String idArticle;
    String nomArticle;
    int quantite;
    String idService;
    String nomService;

    public int getSemaine() {
        return semaine;
    }
    public void setSemaine(int semaine) {
        this.semaine = semaine;
    }

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

    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getIdService() {
        return idService;
    }
    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNomService() {
        return nomService;
    }
    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public BesoinGlobalDTO(Tuple tuple) {
        Object semaineObjet = tuple.get("semaine");
        
        this.semaine = (semaineObjet != null) ? ((Double) semaineObjet).intValue() : 0;
        this.idService = (String) tuple.get("id_service");
        this.idArticle = (String) tuple.get("id_article");
        this.nomArticle = (String) tuple.get("nom_article");
        this.nomService = (String) tuple.get("nom_service");
        this.quantite = ((Long) tuple.get("quantite")).intValue();
    }
    
}
