package com.systeme.commercial.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "entree")
public class Entree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "dateEntree")
    Date dateEntree;

    @Column(name = "idArticle")
    String idArticle;

    @Column(name = "prix")
    double prix;

    @Column(name = "qteEntree")
    double qteEntree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQteEntree() {
        return qteEntree;
    }

    public void setQteEntree(double qteEntree) {
        this.qteEntree = qteEntree;
    }

    public Entree(){
        
    }
}
