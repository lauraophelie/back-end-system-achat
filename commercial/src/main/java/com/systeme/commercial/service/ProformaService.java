package com.systeme.commercial.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.systeme.commercial.model.Besoin;
import com.systeme.commercial.model.BesoinArticle;
import com.systeme.commercial.model.Proforma;
import com.systeme.commercial.repository.BesoinRepository;
import com.systeme.commercial.repository.ProformaRepository;

import jakarta.transaction.Transactional;

@Service
public class ProformaService {

    ProformaRepository repository;

    public ProformaService(ProformaRepository repository) {
        this.repository = repository;
    }

     @Transactional
    public void createProforma(String[] idArticles, int[] quantites,double[] prixU, String idfournisseur, Date date) {

        for (int i = 0; i < idArticles.length; i++) {
            Proforma proforma = new Proforma(); 
            proforma.setIdArticle(idArticles[i]);
            proforma.setQuantite(quantites[i]);
            proforma.setPrixU(prixU[i]);
            proforma.setIdFournisseur(idfournisseur);
            proforma.setDateProforma(date);

            repository.createProforma(proforma.getIdArticle(), proforma.getQuantite(),proforma.getPrixU(),proforma.getIdFournisseur(),proforma.getDateProforma());
            repository.flush();
        }

}
}
