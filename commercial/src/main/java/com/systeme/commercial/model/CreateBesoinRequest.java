package com.systeme.commercial.model;

import java.sql.Date;
import java.util.List;

public class CreateBesoinRequest {
    private String idService;
    private Date dateBesoin;
    private Date dateLimite;
    private int etat;
    private List<BesoinArticle> besoinArticles;
    
    public String getIdService() {
        return idService;
    }
    public void setIdService(String idService) {
        this.idService = idService;
    }
    public Date getDateBesoin() {
        return dateBesoin;
    }
    public void setDateBesoin(Date dateBesoin) {
        this.dateBesoin = dateBesoin;
    }
    public Date getDateLimite() {
        return dateLimite;
    }
    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }
    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat) {
        this.etat = etat;
    }
    public List<BesoinArticle> getBesoinArticles() {
        return besoinArticles;
    }
    public void setBesoinArticles(List<BesoinArticle> besoinArticles) {
        this.besoinArticles = besoinArticles;
    }

    // Getters et setters
}
