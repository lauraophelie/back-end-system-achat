package com.systeme.commercial.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.systeme.commercial.*;
import com.systeme.commercial.model.Sortie;

import jakarta.transaction.Transactional;

@Repository
public interface SortieRepository extends JpaRepository<Sortie, Integer>{
  @Modifying
  @Transactional
  @Query(value = "INSERT INTO sortie (dateSortie, idArticle, qteSortie) VALUES (:dateSortie, :idArticle, :qteSortie)", nativeQuery = true)
  void createSortie(@Param("dateSortie") Date dateSortie,
                      @Param("idArticle") String idArticle,
                      @Param("qteSortie") double qteSortie
                    );

  @Query(value = "select sum(qtesortie) as qtesortie  from sortie where idarticle like :idArticle and dateSortie<:dateDebut", nativeQuery = true)
  double getSumSortieBeforeDate(@Param("idArticle") String idArticle,
                                @Param("dateDebut") Date dateDebut);          
} 
