package com.systeme.commercial.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.commercial.model.ProformaMinDTO;
import com.systeme.commercial.service.ProformaMinService;

@RestController
@RequestMapping("/api/proforma-min")
public class ProformaMinController {

    private final ProformaMinService proformaMinService;

    public ProformaMinController(ProformaMinService proformaMinService) {
        this.proformaMinService = proformaMinService;
    }

    @GetMapping("/all")
    public List<ProformaMinDTO> getAllProformaMin() {
        return proformaMinService.findAllProformaMin();
    }
}
