package com.systeme.commercial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.commercial.service.BesoinService;

@RestController
@RequestMapping("/api/besoin")
public class BesoinController {
    BesoinService service;

    public BesoinController(BesoinService service) {
        this.service = service;
    }
}