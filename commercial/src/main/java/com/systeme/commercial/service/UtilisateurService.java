package com.systeme.commercial.service;

import org.springframework.stereotype.Service;

import com.systeme.commercial.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
    UtilisateurRepository repository;

    public UtilisateurService(UtilisateurRepository repository) {
        this.repository = repository;
    }
}
