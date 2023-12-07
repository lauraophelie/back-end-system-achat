package com.systeme.commercial.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.systeme.commercial.model.Entree;

import jakarta.transaction.Transactional;

@Repository
public interface EntreeRepository extends JpaRepository<Entree, Integer>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO entree (dateEntree, idArticle, prix, qteEntree) VALUES (:dateEntree, :idArticle, :prix, :qteEntree)", nativeQuery = true)
    void createEntree(@Param("dateEntree") Date dateEntree,
                        @Param("idArticle") String idArticle,
                        @Param("prix") double prix,
                        @Param("qteEntree") double qteEntree
                      );
    
} 