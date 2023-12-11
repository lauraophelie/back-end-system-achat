package com.systeme.commercial.model;

import java.sql.Date;

public class Etatstock {
    Date dateDebut;
    Date dateFin;
    String idArticle;
    double qteInitial;
    double qteSortie;
    double reste;
    double montant; 
    double pump;
    
    public Date getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    public Date getDateFin() {
        return dateFin;
    }
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    public String getIdArticle() {
        return idArticle;
    }
    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }
    public double getQteInitial() {
        return qteInitial;
    }
    public void setQteInitial(double qteInitial) {
        this.qteInitial = qteInitial;
    }
    public double getQteSortie() {
        return qteSortie;
    }
    public void setQteSortie(double qteSortie) {
        this.qteSortie = qteSortie;
    }
    public double getReste() {
        return reste;
    }
    public void setReste(double reste) {
        this.reste = reste;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public double getPump() {
        return pump;
    }
    public void setPump(double pump) {
        this.pump = pump;
    }
}
