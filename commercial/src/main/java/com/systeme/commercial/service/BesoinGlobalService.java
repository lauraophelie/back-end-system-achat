package com.systeme.commercial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.systeme.commercial.model.BesoinGlobalDTO;
import com.systeme.commercial.repository.BesoinGlobalRepository;

import jakarta.persistence.Tuple;

@Service
public class BesoinGlobalService {
    private final BesoinGlobalRepository repository;

    public BesoinGlobalService(BesoinGlobalRepository repository) {
        this.repository = repository;
    }

    public List<BesoinGlobalDTO> getAllBesoinGlobalDTO() {
        List<Tuple> tuples = repository.findAllBesoinGlobalDTO();
        List<BesoinGlobalDTO> result = new ArrayList<>();

        for (Tuple tuple : tuples) {
            result.add(new BesoinGlobalDTO(tuple));
        }

        return result;
    }
}
