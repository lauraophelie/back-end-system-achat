package com.systeme.commercial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api.APIResponse;
import com.demo.demo.model.NewSortie;
import com.demo.demo.service.SortieService;

@RestController
@RequestMapping("/api/sortie")
@CrossOrigin(origins = "*")
public class SortieController {
    public SortieService service;

    public SortieController(SortieService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<?> newSortie(@RequestBody NewSortie newSortie) {

        try {
            service.addSortie(newSortie.getIdArticle(), newSortie.getQteSortie(), newSortie.getDateSortie());
            return ResponseEntity.ok(new APIResponse("", true));
        }  catch (Exception e) {
            APIResponse response = new APIResponse(e.toString(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
