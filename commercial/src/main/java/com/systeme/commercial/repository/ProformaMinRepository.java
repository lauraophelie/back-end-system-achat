package com.systeme.commercial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.systeme.commercial.model.ProformaMin;

import jakarta.persistence.Tuple;

@Repository
public interface ProformaMinRepository extends JpaRepository<ProformaMin, String>  {
    @Query(value = "SELECT id_article,id, nomarticle, dateproforma, prixtotal, nomfournisseur, etat FROM vue_prix_minimum_par_article_et_date", nativeQuery = true)
    List<Tuple> findAllProformaMin();   
}
