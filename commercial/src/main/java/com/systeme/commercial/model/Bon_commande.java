package com.systeme.commercial.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bon_commande")
public class Bon_commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "datetirage")
    Date dateTirage;

    @Column(name = "numero")
    String numero;

    @Column(name = "delailivraison")
    Date delaiLivraison;

    @Column(name = "partiel")
    boolean partiel;

    @Column(name = "paiement")
    String paiement;

    @Column(name = "id_proforma")
    int id_proforma;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTirage() {
        return dateTirage;
    }

    public void setDateTirage(Date dateTirage) {
        this.dateTirage = dateTirage;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDelaiLivraison() {
        return delaiLivraison;
    }

    public void setDelaiLivraison(Date delaiLivraison) {
        this.delaiLivraison = delaiLivraison;
    }

    public boolean isPartiel() {
        return partiel;
    }

    public void setPartiel(boolean partiel) {
        this.partiel = partiel;
    }

    public String getPaiement() {
        return paiement;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    public int getId_proforma() {
        return id_proforma;
    }

    public void setId_proforma(int id_proforma) {
        this.id_proforma = id_proforma;
    }
}
