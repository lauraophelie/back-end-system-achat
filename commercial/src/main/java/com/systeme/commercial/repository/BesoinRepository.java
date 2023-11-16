package com.systeme.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systeme.commercial.model.Besoin;

@Repository
public interface BesoinRepository extends JpaRepository<Besoin, String> {
    
}
