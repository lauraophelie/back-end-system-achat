package com.systeme.commercial.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.systeme.commercial.model.Besoin;
import com.systeme.commercial.model.BesoinArticle;
import com.systeme.commercial.model.BesoinGlobal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public interface BesoinRepository extends JpaRepository<Besoin, Integer> {
    @Query("SELECT b FROM Besoin b ORDER BY b.dateBesoin DESC")
    Besoin findLastBesoin();

    Besoin findTopByOrderByIdDesc();

    
    @Query(value = "SELECT * FROM v_besoin_global_byservice", nativeQuery = true)
    List<BesoinGlobal> FindAllV_Besoins_Global();
  
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO besoin (id_service, date_besoin, date_limite, etat) VALUES (:idService, :dateBesoin, :dateLimite, :etat)", nativeQuery = true)
    void createBesoin(@Param("idService") String idService,
                      @Param("dateBesoin") Date dateBesoin,
                      @Param("dateLimite") Date dateLimite,
                      @Param("etat") int etat);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO besoin_article (id_besoin, id_article, quantite) VALUES (:idBesoin, :idArticle, :quantite)", nativeQuery = true)
    void addArticleToBesoin(@Param("idBesoin") int idBesoin,
                            @Param("idArticle") String idArticle,
                            @Param("quantite") int quantite);

                            @Modifying
    @Transactional
    @Query(value = "INSERT INTO validation_besoin (id_besoin, date_validation) VALUES (:id_besoin, :date_validation)", nativeQuery = true)
    void addValidationBesoin(@Param("id_besoin") int id_besoin,
                            @Param("date_validation") Date date);

    void save(BesoinArticle article);

}
