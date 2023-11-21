package com.systeme.commercial.service;

import org.springframework.stereotype.Service;

import com.systeme.commercial.model.Utilisateur;
import com.systeme.commercial.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
    UtilisateurRepository repository;

    public UtilisateurService(UtilisateurRepository repository) {
        this.repository = repository;
    }
    public boolean verifierUtilisateur(Utilisateur utilisateur) {
        Utilisateur utilisateurEnBase = repository.findByEmailAndPassword(utilisateur.getEmail(), utilisateur.getPassword());

        return utilisateurEnBase != null;
    }

    public Utilisateur checkUtilisateur(Utilisateur utilisateur) {
        return repository.findByEmailAndPassword(utilisateur.getEmail(), utilisateur.getPassword());
    }
}
