package com.systeme.commercial.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idstock")
    int idStock;

    @Column(name = "datestock")
    Date dateStock;

    @Column(name = "idarticle")
    String idarticle;

    @Column(name = "prixu")
    double prixU;

    @Column(name = "qteinstock")
    double qteInStock;

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public Date getDateStock() {
        return dateStock;
    }

    public void setDateStock(Date dateStock) {
        this.dateStock = dateStock;
    }

    public String getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(String idarticle) {
        this.idarticle = idarticle;
    }

    public double getPrixU() {
        return prixU;
    }

    public void setPrixU(double prixU) {
        this.prixU = prixU;
    }

    public double getQteInStock() {
        return qteInStock;
    }

    public void setQteInStock(double qteInStock) {
        this.qteInStock = qteInStock;
    }
}
