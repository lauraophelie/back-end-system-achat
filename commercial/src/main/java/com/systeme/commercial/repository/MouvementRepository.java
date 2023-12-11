package com.systeme.commercial.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.systeme.commercial.model.Entree;
import com.systeme.commercial.model.Mouvement;

import jakarta.transaction.Transactional;

@Repository
public interface MouvementRepository extends JpaRepository<Mouvement, Integer>{
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO mouvement (identree, dateget_entree, qtein_entree, idsortie, date_sortie, qtea_sortir, restefordate_entree, restea_sortir, prixentree, qtesortie_initiale, idarticle) VALUES (:identree, :dateget_entree, :qtein_entree, :idsortie, :date_sortie, :qtea_sortir, :restefordate_entree, :restea_sortir, :prixentree, :qtesortie_initiale, :idarticle)", nativeQuery = true)
    void createMouvement(@Param("identree") int identree,
                        @Param("dateget_entree") Date dateget_entree,
                        @Param("qtein_entree") double qtein_entree,
                        @Param("idsortie") int idsortie,
                        @Param("date_sortie") Date date_sortie,
                        @Param("qtea_sortir") double qtea_sortir,
                        @Param("restefordate_entree") double restefordate_entree,
                        @Param("restea_sortir") double restea_sortir,
                        @Param("prixentree") double prixentree,
                        @Param("qtesortie_initiale") double qtesortie_intiale,
                        @Param("idarticle") String idarticle
                      );


    @Query(value = "select * from mouvement where idarticle like :idArticle  and date_sortie =:dateSortie",nativeQuery = true)
    Mouvement[] get_MouvementFor_OneDateSortie(@Param("idArticle") String idArticle,
                                               @Param("dateSortie") Date dateSortie);

    @Query(value = "select sum(qtesortie) as qtesortie from sortie where idarticle like :idArticle and datesortie>=:dateDebut and datesortie<=:dateFin",nativeQuery = true)
    double qteSortieEntre2Dates(@Param("idArticle") String idArticle,
                                @Param("dateDebut") Date dateDebut,
                                @Param("dateFin") Date dateFin);

    @Query(value = "select qteIn_entree,prixentree,restefordate_entree  from mouvement where idarticle like :idArticle  and date_sortie<:dateDebut",nativeQuery = true)   
    double getMontant_SortieBeforeDate(@Param("idArticle") String idArticle,
                                      @Param("dateDebut") Date dateDebut);
                                      
    @Query(value = "select qteIn_entree,prixentree,restefordate_entree  from mouvement where idarticle like :idArticle and date_sortie>=:dateDebut and date_sortie<=:dateFin",nativeQuery = true)
    double getMontant_SortieBetweenDate(@Param("idArticle") String idArticle,
                                        @Param("dateDebut") Date dateDebut,
                                        @Param("dateFin") Date dateFin);
}
