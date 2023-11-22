package com.systeme.commercial.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.systeme.commercial.model.Proforma;

import jakarta.transaction.Transactional;

@Repository
public interface ProformaRepository extends JpaRepository<Proforma,String>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO proforma (id_article, quantite, prixUnitaire, id_fournisseur, dateProforma) VALUES (:id_article, :quantite, :prixUnitaire, :id_fournisseur, :dateProforma)", nativeQuery = true)
    void createProforma(@Param("id_article") String idArticle,
                        @Param("quantite") int quantite,
                        @Param("prixUnitaire") double prixUnitaire,
                        @Param("id_fournisseur") String id_fournisseur,
                        @Param("dateProforma") Date dateProforma
                      );
    
}