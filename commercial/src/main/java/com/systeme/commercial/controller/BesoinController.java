package com.systeme.commercial.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.commercial.api.APIResponse;
import com.systeme.commercial.model.Besoin;
import com.systeme.commercial.model.BesoinArticle;
import com.systeme.commercial.model.BesoinGlobal;
import com.systeme.commercial.model.CreateBesoinArticle;
import com.systeme.commercial.model.CreateBesoinRequest;
import com.systeme.commercial.service.BesoinService;

@RestController
@RequestMapping("/api/besoin")
@CrossOrigin(origins = "*")
public class BesoinController {
    BesoinService service;

    public BesoinController(BesoinService service) {
        this.service = service;
    }

    @PostMapping("/last")
    public ResponseEntity<?> getLastBesoin() {
        try {
            Besoin dernierBesoin = service.findLastBesoin();
            return ResponseEntity.ok(new APIResponse("", dernierBesoin));
        }  catch (Exception e) {
            APIResponse response = new APIResponse(e.toString(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createBesoin(@RequestBody CreateBesoinRequest request) {
        try {
            service.createBesoin(
                    request.getIdService(),
                    request.getDateBesoin(),
                    request.getDateLimite(),
                    request.getEtat()
            );

            return ResponseEntity.ok(new APIResponse("Besoin créé avec succès, ID: " , true));
        } catch (Exception e) {
            APIResponse response = new APIResponse("Erreur lors de la création du besoin: " + e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

   @PostMapping("/createWithArticles")
    public ResponseEntity<APIResponse> createBesoinWithArticles(@RequestBody CreateBesoinArticle request) {
        try {
            service.createBesoinWithArticles(request.getIdArticles(),request.getQte());
            return ResponseEntity.ok(new APIResponse("Besoin créé avec succès, ID: " , true));
            
        } catch (Exception e) {
            // TODO: handle exception
            APIResponse response = new APIResponse("Erreur lors de la création du besoin: " + e.getMessage(), false);
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateBesoin(@RequestBody Besoin besoin,@PathVariable int id) {
        try {
            service.updateBesoin(besoin,id);
            service.addValidationBesoin(id, Date.valueOf(LocalDate.now()));
            return ResponseEntity.ok(new APIResponse("Besoin update avec succès, ID: " , true));
            
        } catch (Exception e) {
            // TODO: handle exception
            APIResponse response = new APIResponse("Erreur lors de la création du besoin: " + e.getMessage(), false);
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

   
}
