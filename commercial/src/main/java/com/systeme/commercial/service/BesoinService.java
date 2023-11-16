package com.systeme.commercial.service;

import org.springframework.stereotype.Service;

import com.systeme.commercial.repository.BesoinRepository;

@Service
public class BesoinService {
    BesoinRepository repository;

    public BesoinService(BesoinRepository repository) {
        this.repository = repository;
    }
}
