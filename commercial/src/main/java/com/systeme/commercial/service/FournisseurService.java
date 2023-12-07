package com.systeme.commercial.service;

import org.springframework.stereotype.Service;

import com.systeme.commercial.repository.FournisseurRepository;
import com.systeme.commercial.model.Fournisseur;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FournisseurService {
    private FournisseurRepository repository;

    public FournisseurService(FournisseurRepository repository) {
        this.repository = repository;
    }

    public List<Fournisseur> findAll() {
        return repository.findAll();
    }

    public Fournisseur findById(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Fournisseur introuvable"));
    }
}
