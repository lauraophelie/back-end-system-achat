package com.systeme.commercial.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.systeme.commercial.model.Entree;
import com.systeme.commercial.repository.EntreeRepository;

import jakarta.transaction.Transactional;

@Service
public class EntreeService {
    EntreeRepository repository;

    public EntreeService(EntreeRepository repository) {
        this.repository = repository;
    }



    @Transactional
    public void addEntree(String[] idArticle, double[] qteEntree, double[] prix, Date dateEntree) {
        for (int i = 0; i < idArticle.length; i++) {
            Entree entree = new Entree(); 
            entree.setIdArticle(idArticle[i]);
            entree.setQteEntree(qteEntree[i]);
            entree.setPrix(prix[i]);
            entree.setDateEntree(dateEntree);

            repository.createEntree(entree.getDateEntree(), entree.getIdArticle(), entree.getPrix(), entree.getQteEntree());
            repository.flush();
        }
    }
}
