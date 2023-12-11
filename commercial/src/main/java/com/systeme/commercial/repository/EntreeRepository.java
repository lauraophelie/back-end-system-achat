package com.systeme.commercial.repository;

import java.sql.Date;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

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


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO stock (datestock, idArticle, prixu, qteinstock) VALUES (:datestock, :idArticle, :prixu, :qteinstock)", nativeQuery = true)
    void createStock(@Param("datestock") Date dateEntree,
                        @Param("idArticle") String idArticle,
                        @Param("prixu") double prix,
                        @Param("qteinstock") double qteEntree
                      );

    @Query(value = "select id,dateentree,idarticle,prix,qteentree from entree where dateentree=(select max(dateentree) from entree where idarticle like :idarticle and dateentree<=:dateentree) ",nativeQuery = true)
    Entree[] get_Last_Entree_OnLifo_ByIdarticle_IdMagasin(@Param("idarticle") String idArticle, 
                                                        @Param("dateentree") Date dateEntree);
    
    
    @Query(value = "select id,dateentree,idarticle,prix,qteentree from entree where  dateentree=(select max(dateentree) from entree where dateentree<':lastDate' and idarticle like :idArticle",nativeQuery = true)
    Entree get_nextEntree_OnLifo_for_qte(@Param("lastDate") Date lastDate,
                                          @Param("idArticle") String idArticle);

    @Query(value = "select id,dateentree,idArticle,prix,qteentree from entree where dateentree=(select min(dateentree) from entree where idarticle like :idArticle  and dateentree<=:dateSortie)",nativeQuery = true)
    ArrayList<Entree> get_First_Entree_OnFifo_ByIdarticle_IdMagasin(@Param("idArticle") String idArticle,
                                                         @Param("dateSortie") Date dateSortie);

    // @Query("SELECT e FROM Entree e WHERE e.idarticle LIKE :idArticle AND e.dateentree <= :dateSortie ORDER BY e.dateentree ASC")
    // Entree get_First_Entree_OnFifo_ByIdarticle_IdMagasin(@Param("idArticle") String idArticle, @Param("dateSortie") Date dateSortie);


    @Query(value = "select id,dateentree,idarticle,prix,qteentree from entree where  dateentree=(select min(dateentree) from entree where dateentree>:lastDate and idarticle like :idArticle)", nativeQuery = true)
    Entree get_nextEntree_OnFifo_for_qte(@Param("lastDate") Date lastDate,
                                        @Param("idArticle") String idArticle);

    @Modifying
    @Query(value = "UPDATE entree  SET dateentree = :dateentree, idarticle = :idarticle, prix= :prix, qteentree=:qteentree WHERE id = :id", nativeQuery = true)
    void updateEntree(@Param("id") int id, 
                      @Param("dateentree") Date dateEntree, 
                      @Param("idarticle") String idArticle,
                      @Param("prix") double prix,
                      @Param("qteentree") double qteEntree);


    @Modifying
    @Query(value = "DELETE FROM entree WHERE id = :id", nativeQuery = true)
    void deleteEntree(@Param("id") int id);
} 