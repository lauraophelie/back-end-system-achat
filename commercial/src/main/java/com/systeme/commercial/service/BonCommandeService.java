package com.systeme.commercial.service;

import com.systeme.commercial.model.Bon_commande;
import com.systeme.commercial.repository.BonCommandeRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BonCommandeService {
    private final BonCommandeRepository bonCommandeRepository;

    public BonCommandeService(BonCommandeRepository bonCommandeRepository) {
        this.bonCommandeRepository = bonCommandeRepository;
    }

    public Bon_commande saveBonCommande(Bon_commande bonCommande) {
        return bonCommandeRepository.save(bonCommande);
    }

    public List<Bon_commande> getAllBonCommandes() {
        return bonCommandeRepository.findAll();
    }
    
    // Vous pouvez ajouter d'autres méthodes de service si nécessaire
}
