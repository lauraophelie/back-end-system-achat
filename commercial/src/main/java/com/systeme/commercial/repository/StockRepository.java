package com.systeme.commercial.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.systeme.commercial.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer>{
    @Query(value = "select sum(qteinStock) as qteinstock  from stock where idarticle like :idArticle and datestock>=:dateDebut and datestock<=:dateFin",nativeQuery = true)
    double getQteStockEntreDate(@Param("idArticle") String idArticle,
                                @Param("dateDebut") Date dateDebut,
                                @Param("dateFin") Date dateFin);

    @Query(value = "select sum(qteinStock) as qteinstock  from stock where idarticle like :idArticle and datestock<:dateDebut",nativeQuery = true)
    double getQteInitialeInStock_BeforeDate(@Param("idArticle") String idArticle,
                                            @Param("dateDebut") Date dateDebut);

    @Query(value = "select qteinStock,prixu  from stock where idarticle like :idArticle  and datestock<:dateDebut",nativeQuery = true)
    double getMontant_ForEtatStock(@Param("idArticle") String idArticle,
                                    @Param("dateDebut") Date dateDebut);

    @Query(value = "select qteinStock,prixu  from stock where idarticle like :idArticle  and datestock>=:dateDebut and datestock<=:dateFin",nativeQuery = true)
    double getMontant_BetweenDate_EtatStock(@Param("idArticle") String idArticle,
                                            @Param("dateDebut") Date dateDebut,
                                            @Param("dateFin") Date dateFin);
}
