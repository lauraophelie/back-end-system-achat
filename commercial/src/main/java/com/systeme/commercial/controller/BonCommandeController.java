package com.systeme.commercial.controller;

import com.systeme.commercial.api.APIResponse;
import com.systeme.commercial.model.Bon_commande;
import com.systeme.commercial.service.BonCommandeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bon-commande")
@CrossOrigin(origins = "*")
public class BonCommandeController {
    private final BonCommandeService bonCommandeService;

    public BonCommandeController(BonCommandeService bonCommandeService) {
        this.bonCommandeService = bonCommandeService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBonCommande(@RequestBody Bon_commande bonCommande) {
         try {
            bonCommandeService.saveBonCommande(bonCommande);
            return ResponseEntity.ok(new APIResponse("", true));
        }  catch (Exception e) {
            APIResponse response = new APIResponse(e.toString(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/all")
    public List<Bon_commande> getAllBonCommandes() {
        return bonCommandeService.getAllBonCommandes();
    }
}
    
    // Vous pouvez ajouter d'autres méthodes du contrôleur si nécessaire
