package com.systeme.commercial.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.commercial.api.APIResponse;
import com.systeme.commercial.model.BesoinGlobal;
import com.systeme.commercial.model.BesoinGlobalDTO;
import com.systeme.commercial.service.BesoinGlobalService;

@RestController
@RequestMapping("/api/besoinglobal")
@CrossOrigin(origins = "*")
public class BesoinGlobalController {
    private final BesoinGlobalService service;

    public BesoinGlobalController(BesoinGlobalService service) {
        this.service = service;
    }

    @GetMapping("/byservice")
    public ResponseEntity<APIResponse> getAllBesoinGlobalByService() {
        try {
            List<BesoinGlobalDTO> besoinGlobalDTOList = service.getAllBesoinGlobalDTO();
            return ResponseEntity.ok(new APIResponse("" , besoinGlobalDTOList));
        } catch (Exception e) {
            APIResponse response = new APIResponse( e.getMessage(), "");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
