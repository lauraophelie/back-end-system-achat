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
import org.springframework.web.bind.annotation.RestController;

import com.systeme.commercial.api.APIResponse;
import com.systeme.commercial.api.ListeAPI;
import com.systeme.commercial.model.Besoin;
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

    @GetMapping("/{idService}")
    public ResponseEntity<APIResponse> findAllByIdService(@PathVariable String idService) {
        try {
            List<Besoin> listeBesoin = service.findAllByIdService(idService);
            int count = listeBesoin.size();

            ListeAPI api = null;

            if(count == 0) {
                api = new ListeAPI("La liste est vide", null, 0);
            } else {
                api = new ListeAPI(null, listeBesoin, count);
            }
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();

            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/findBesoin/{id}")
    public ResponseEntity<APIResponse> findById(@PathVariable int id) {
        try {
            Besoin find = service.findById(id);
            APIResponse api = new APIResponse(null, find);

            return ResponseEntity.ok(api);
        } catch (Exception e) {
            e.printStackTrace();

            APIResponse response = new APIResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
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
            return ResponseEntity.ok(new APIResponse(null, true));
        } catch (Exception e) {
            APIResponse response = new APIResponse("Erreur lors de la création du besoin: " + e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

   @PostMapping("/createWithArticles")
    public ResponseEntity<APIResponse> createBesoinWithArticles(@RequestBody CreateBesoinArticle request) {
        try {
            service.createBesoinWithArticles(request.getIdArticles(),request.getQte());
            return ResponseEntity.ok(new APIResponse(null, true));
            
        } catch (Exception e) {
            // TODO: handle exception
            APIResponse response = new APIResponse("Erreur lors de la création du besoin: " + e.getMessage(), false);
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateBesoin(@RequestBody Besoin besoin, @PathVariable int id) {
        try {
            service.updateBesoin(besoin, id);
            service.addValidationBesoin(id, Date.valueOf(LocalDate.now()));

            return ResponseEntity.ok(new APIResponse(null, true));
        } catch (Exception e) {
            // TODO: handle exception
            APIResponse response = new APIResponse("Erreur lors de la création du besoin: " + e.getMessage(), false);
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

   
}
