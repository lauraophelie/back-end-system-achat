package com.systeme.commercial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.commercial.api.APIResponse;
import com.systeme.commercial.model.Entree;
import com.systeme.commercial.model.NewEntree;
import com.systeme.commercial.model.NewProforma;
import com.systeme.commercial.service.EntreeService;

@RestController
@RequestMapping("/api/entree")
@CrossOrigin(origins = "*")
public class EntreeController {
    public EntreeService service;

    public EntreeController(EntreeService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<?> newEntree(@RequestBody NewEntree newEntree) {

        try {
            service.addEntree(newEntree.getIdArticle(), newEntree.getQteEntree(), newEntree.getPrix(), newEntree.getDateEntree());
            return ResponseEntity.ok(new APIResponse("", true));
        }  catch (Exception e) {
            APIResponse response = new APIResponse(e.toString(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
