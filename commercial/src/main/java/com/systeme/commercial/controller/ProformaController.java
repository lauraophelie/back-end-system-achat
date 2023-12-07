package com.systeme.commercial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.commercial.api.APIResponse;
import com.systeme.commercial.model.NewProforma;
import com.systeme.commercial.service.ProformaService;


@RestController
@RequestMapping("/api/proforma")
@CrossOrigin(origins = "*")
public class ProformaController {
    public ProformaService service;

    public ProformaController(ProformaService service) {
        this.service = service;
    }
    @PostMapping("/new")
    public ResponseEntity<?> newProforma(@RequestBody NewProforma proforma) {

        try {
            service.createProforma(proforma.getIdArticle(), proforma.getQuantites(), proforma.getPrixU(), proforma.getIdFournisseurs(), proforma.getDate());
            return ResponseEntity.ok(new APIResponse("", true));
        }  catch (Exception e) {
            APIResponse response = new APIResponse(e.toString(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
