package com.systeme.commercial.service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.systeme.commercial.model.Besoin;
import com.systeme.commercial.model.BesoinArticle;
import com.systeme.commercial.model.BesoinGlobal;
import com.systeme.commercial.repository.BesoinRepository;

import jakarta.transaction.Transactional;

@Service
public class BesoinService {
    BesoinRepository repository;

    public BesoinService(BesoinRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public int createBesoin(String idService, Date dateBesoin, Date dateLimite, int etat) {
        Besoin besoin = new Besoin();
        besoin.setIdService(idService);
        besoin.setDateBesoin(dateBesoin);
        besoin.setDateLimite(dateLimite);
        besoin.setEtat(etat);

        Besoin savedBesoin = repository.save(besoin);
        return savedBesoin.getId();
    }
   
   

    @Transactional
    public Besoin createBesoinWithArticles(String[] idArticles, int[] quantites) {
        Besoin besoin = repository.findTopByOrderByIdDesc();

        System.out.println("besoin = "+besoin.getId());
        for (int i = 0; i < idArticles.length; i++) {
            BesoinArticle besoinArticle = new BesoinArticle(); 
            besoinArticle.setIdBesoin(besoin.getId());
            besoinArticle.setIdArticle(idArticles[i]);
            besoinArticle.setQuantite(quantites[i]);

            System.out.println(besoinArticle.getIdBesoin());

            repository.addArticleToBesoin(besoinArticle.getIdBesoin(),besoinArticle.getIdArticle(),besoinArticle.getQuantite());
            repository.flush();
        }
        return besoin;
    }

    @Transactional
    public void addValidationBesoin(int idBesoin, Date date) {
        repository.addValidationBesoin(idBesoin, date);
    }

    public Besoin findLastBesoin() {
        return repository.findTopByOrderByIdDesc();
    }

    public void updateBesoin(Besoin besoin, int id){
        Besoin besoin2 = repository.findById(id).orElseThrow(()-> new NoSuchElementException("besoin not found"));
        besoin2.setEtat(besoin.getEtat());
        repository.save(besoin2);
    }

    public List<BesoinGlobal> getAllBesoinGlobalByService() {
        return repository.FindAllV_Besoins_Global();
    }

    public List<Besoin> findAllByIdService(String idService) {
        return repository.findAllByIdService(idService);
    }

    public Besoin findById(int id) {
        return repository.findById(id).orElseThrow(()-> new NoSuchElementException("besoin not found"));
    }
   
}