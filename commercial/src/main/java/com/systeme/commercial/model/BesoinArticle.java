package com.systeme.commercial.model;

import org.hibernate.engine.internal.ForeignKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "besoin_article")
public class BesoinArticle {

    @Column(name = "id_besoin")
    private int idBesoin;

    public int getIdBesoin() {
        return idBesoin;
    }

    public void setIdBesoin(int idBesoin) {
        this.idBesoin = idBesoin;
    }

    @Id
    @Column(name = "id_article")
    private String idArticle;

    @Column(name = "quantite")
    private int quantite;

    // @ManyToOne
    // @JoinColumn(name = "id_article")
    // private Article article;

    // @ManyToOne
    // @JoinColumn(name = "id_besoin")
    // private Besoin besoin;

   

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

    // public Article getArticle() {
    //     return article;
    // }

    // public void setArticle(Article article) {
    //     this.article = article;
    // }

    // public Besoin getBesoin() {
    //     return besoin;
    // }

    // public void setBesoin(Besoin besoin) {
    //     this.besoin = besoin;
    // }

}