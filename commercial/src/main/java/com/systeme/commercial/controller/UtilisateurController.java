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

    @PostMapping("/utilisateur")
    public ResponseEntity<APIResponse> getUtilisateur(@RequestBody Utilisateur utilisateur) {
        try {
            boolean estValide = service.verifierUtilisateur(utilisateur);

            if (estValide) {
                return ResponseEntity.ok(new APIResponse("", true));
            } else {
                return ResponseEntity.ok(new APIResponse("", false));
            }
        } catch (Exception e) {
            APIResponse response = new APIResponse(e.toString(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}