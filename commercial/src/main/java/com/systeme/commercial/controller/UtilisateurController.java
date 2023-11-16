package com.systeme.commercial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.commercial.api.APIResponse;
import com.systeme.commercial.model.Utilisateur;
import com.systeme.commercial.service.UtilisateurService;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class UtilisateurController {
    UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }

    @PostMapping("/api/login/utilisateur")
    public ResponseEntity<APIResponse> getUtilisateur(@RequestBody Utilisateur utilisateur) {
        /// verification utilisateur
        return null;
    }
}
