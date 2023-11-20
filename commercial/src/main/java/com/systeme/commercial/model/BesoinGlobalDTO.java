package com.systeme.commercial.model;

import java.math.BigDecimal;

import jakarta.persistence.Tuple;

public class BesoinGlobalDTO {
    int semaine;
    String idArticle;
    int quantite;
    String idService;

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

    public BesoinGlobalDTO(Tuple tuple) {
        // this.semaine = ((BigDecimal) tuple.get("semaine")).intValue();
        Object semaineObjet = tuple.get("semaine");
    this.semaine = (semaineObjet != null) ? ((BigDecimal) semaineObjet).intValue() : 0;

    this.idService = (String) tuple.get("id_service");
        this.idArticle = (String) tuple.get("id_article");
        this.quantite = ((Long) tuple.get("quantite")).intValue();
        this.idService = (String) tuple.get("id_service");
    }
}
