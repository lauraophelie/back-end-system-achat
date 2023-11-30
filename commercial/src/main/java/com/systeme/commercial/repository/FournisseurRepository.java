package com.systeme.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systeme.commercial.model.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, String> {
     
}
