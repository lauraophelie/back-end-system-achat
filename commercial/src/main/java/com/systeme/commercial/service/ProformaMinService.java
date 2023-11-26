package com.systeme.commercial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.systeme.commercial.model.BesoinGlobalDTO;
import com.systeme.commercial.model.ProformaMin;
import com.systeme.commercial.model.ProformaMinDTO;
import com.systeme.commercial.repository.BesoinGlobalRepository;
import com.systeme.commercial.repository.ProformaMinRepository;

import jakarta.persistence.Tuple;

@Service
public class ProformaMinService {
    private final ProformaMinRepository repository;

    public ProformaMinService(ProformaMinRepository repository) {
        this.repository = repository;
    }

    public List<ProformaMinDTO> findAllProformaMin() {
        List<Tuple> tuples = repository.findAllProformaMin();
        List<ProformaMinDTO> result = new ArrayList<>();

        for (Tuple tuple : tuples) {
            result.add(new ProformaMinDTO(tuple));
        }

        return result;
    }
}
