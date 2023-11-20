package com.systeme.commercial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.systeme.commercial.model.BesoinGlobal;
import com.systeme.commercial.model.BesoinGlobalDTO;

import jakarta.persistence.Tuple;

@Repository
public interface BesoinGlobalRepository extends JpaRepository<BesoinGlobal, Integer> {
    @Query(value = "SELECT * FROM v_besoin_global_byservice", nativeQuery = true)
    List<Tuple> findAllBesoinGlobalDTO();

}
