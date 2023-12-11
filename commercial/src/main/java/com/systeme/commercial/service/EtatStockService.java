package com.systeme.commercial.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.systeme.commercial.model.Entree;
import com.systeme.commercial.model.Etatstock;
import com.systeme.commercial.model.Mouvement;
import com.systeme.commercial.model.Sortie;
import com.systeme.commercial.model.Stock;
import com.systeme.commercial.repository.EntreeRepository;
import com.systeme.commercial.repository.MouvementRepository;
import com.systeme.commercial.repository.SortieRepository;
import com.systeme.commercial.repository.StockRepository;

@Service
public class EtatStockService {
    MouvementRepository mouvement;
    StockRepository stock;
    SortieRepository sortie;

    public EtatStockService(MouvementRepository mouvement,StockRepository stock, SortieRepository sortie) {
        this.mouvement = mouvement;
        this.stock = stock;
        this.sortie = sortie;
    }

    public double getQteInitiale_ForEtatstock(String idArticle, Date dateDebut) {
        double sum = 0;
        // Stock stock = new Stock();
        // Sortie sortie = new Sortie();
        try {
            sum = stock.getQteInitialeInStock_BeforeDate(idArticle,  dateDebut)-sortie.getSumSortieBeforeDate(idArticle, dateDebut);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return sum;
    }

    public double getRealMontant(String idArticle, Date dateDebut, Date dateFin){
        double montant = 0;
        // Stock stock = new Stock();
        // Mouvement mouvement = new Mouvement();
        try {
           
            montant = (stock.getMontant_ForEtatStock(idArticle, dateDebut)+stock.getMontant_BetweenDate_EtatStock(idArticle, dateDebut, dateFin))-(mouvement.getMontant_SortieBeforeDate(idArticle, dateDebut)+mouvement.getMontant_SortieBetweenDate(idArticle, dateDebut, dateFin));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("montant tena izy = "+montant);
        return montant;
    }

    public Etatstock getEtatStock_ByIdArticle_Idmagasin_date(String idArticle, Date dateDebut, Date dateFin){
        
        Etatstock etatstock = new Etatstock();
        // Mouvement mouvement = new Mouvement();
        Mouvement mouvForGetMontant = new Mouvement();
        Entree entree = new Entree();
        double montant = 0;
        double pump = 0;
        double entreeNiala = 0;
        double qteInitiale = 0;
        double reste = 0;
        // Stock stock = new Stock();
        Etatstock s = new Etatstock();
        try {
            etatstock.setDateDebut(dateDebut);
            etatstock.setDateFin(dateFin);
            etatstock.setIdArticle(idArticle);
            etatstock.setQteSortie(mouvement.qteSortieEntre2Dates(idArticle, dateDebut, dateFin));
            System.out.println("etatstock sortie = "+etatstock.getQteSortie());
            qteInitiale = this.getQteInitiale_ForEtatstock(idArticle, dateDebut);
            etatstock.setQteInitial(qteInitiale);
            // double qte2 = 0;
            // System.out.println("blabla = "+this.getRealMontant(idArticle, dateDebut, dateFin));
            etatstock.setMontant(this.getRealMontant(idArticle, dateDebut, dateFin));
            
            reste = etatstock.getQteInitial()+stock.getQteStockEntreDate(idArticle, dateDebut, dateFin)-etatstock.getQteSortie();
            
            etatstock.setReste(reste);
            pump = etatstock.getMontant()/etatstock.getReste();
            etatstock.setPump(pump);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return etatstock;
    }

}
