package com.systeme.commercial.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.commercial.service.UtilisateurService;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class UtilisateurController {
    UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }
}
