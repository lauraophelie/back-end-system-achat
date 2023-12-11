package com.systeme.commercial.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.systeme.commercial.model.Article;
import com.systeme.commercial.model.Entree;
import com.systeme.commercial.model.Mouvement;
import com.systeme.commercial.model.Sortie;
import com.systeme.commercial.repository.ArticleRepository;
import com.systeme.commercial.repository.EntreeRepository;
import com.systeme.commercial.repository.MouvementRepository;
import com.systeme.commercial.repository.SortieRepository;

import jakarta.transaction.Transactional;

@Service
public class SortieService {
    SortieRepository repository;
    EntreeRepository entreeRepository;
    ArticleRepository articleRepository;
    MouvementRepository mouvementRepository;

    public SortieService(SortieRepository repository,EntreeRepository entreeRepository,ArticleRepository articleRepository, MouvementRepository mouvementRepository) {
        this.repository = repository;
        this.entreeRepository=entreeRepository;
        this.articleRepository = articleRepository;
        this.mouvementRepository = mouvementRepository;
    }

    

    public void getResteForOutput_Lifo(Entree entree, Sortie sortie, double qteInitiale){
        System.out.println("idsortie ao am getresteForOutput = "+sortie.getIdSortie());
        double resteForOutput = 0;
        double reste = 0;
        if ((entree.getQteEntree()-sortie.getQteSortie())<0){
            try {
                System.out.println("-------------------makato am condition initial <0");
                System.out.println("diff = "+(entree.getQteEntree()-sortie.getQteSortie()));
                resteForOutput = sortie.getQteSortie()-entree.getQteEntree();
                System.out.println("Entree à sortir en cours = "+entree.getQteEntree());
                System.out.println("Sortie now = "+sortie.getQteSortie());
                System.out.println("Reste a sortir = "+resteForOutput);
                System.out.println("last entree = "+entree.getDateEntree());
                System.out.println("reste entree = "+(entree.getQteEntree()-sortie.getQteSortie()));
                System.out.println("prix entree = "+entree.getPrix());

                if ((entree.getQteEntree()-sortie.getQteSortie())<0) {
                    reste = 0;
                }
                else{
                    reste = (entree.getQteEntree()-sortie.getQteSortie());
                }
                mouvementRepository.createMouvement(entree.getId(), entree.getDateEntree(), entree.getQteEntree(), sortie.getIdSortie(), sortie.getDateSortie(), sortie.getQteSortie(), reste, resteForOutput, entree.getPrix(),qteInitiale, entree.getIdArticle());

                Entree nextEntree = entreeRepository.get_nextEntree_OnLifo_for_qte(entree.getDateEntree(),sortie.getIdArticle()); 
                entree.setQteEntree(nextEntree.getQteEntree());
                entree.setDateEntree(nextEntree.getDateEntree());
                entree.setPrix(nextEntree.getPrix());
                entree.setId(nextEntree.getId());
                sortie.setQteSortie(resteForOutput);
                entree.setDateEntree(nextEntree.getDateEntree());

                System.out.println("next date entree = "+nextEntree.getDateEntree());
                this.getResteForOutput_Lifo(entree, sortie, qteInitiale);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        if(resteForOutput==0){
            
            System.out.println("vita calcul");
            System.out.println("Entree now final = "+entree.getQteEntree());
            System.out.println("Sortie now final = "+sortie.getQteSortie());
            System.out.println("Reste a sortir final = "+resteForOutput);
            
            // entree farany tavela ao anaty base t@
            System.out.println("reste entree = "+(entree.getQteEntree()-sortie.getQteSortie()));
            System.out.println("last entree final = "+entree.getDateEntree());
            // ---------------------------------------------------
            
            mouvementRepository.createMouvement(entree.getId(), entree.getDateEntree(), entree.getQteEntree(), sortie.getIdSortie(), sortie.getDateSortie(), sortie.getQteSortie(), (entree.getQteEntree()-sortie.getQteSortie()), resteForOutput, entree.getPrix(), qteInitiale, entree.getIdArticle());
        }
    }

    public void getResteForOutput_Fifo(Entree entree, Sortie sortie, double qteInitiale){
        System.out.println("idsortie ao am getresteForOutput = "+sortie.getIdSortie());

        double reste = 0;
        double resteForOutput = 0;
        System.out.println("idsortie = "+sortie.getIdSortie());
        if ((entree.getQteEntree()-sortie.getQteSortie())<0){
            try {
                System.out.println("-------------------makato am condition initial <0");
                System.out.println("diff = "+(entree.getQteEntree()-sortie.getQteSortie()));
                resteForOutput = sortie.getQteSortie()-entree.getQteEntree();
                System.out.println("Entree à sortir en cours = "+entree);
                System.out.println("Sortie now = "+sortie);
                System.out.println("Reste a sortir = "+resteForOutput);
                System.out.println("last entree = "+entree.getDateEntree());

                if ((entree.getQteEntree()-sortie.getQteSortie())<0) {
                    reste = 0;
                }
                else{
                    reste = (entree.getQteEntree()-sortie.getQteSortie());
                }
                mouvementRepository.createMouvement(entree.getId(), entree.getDateEntree(), entree.getQteEntree(), sortie.getIdSortie(), sortie.getDateSortie(), sortie.getQteSortie(), reste, resteForOutput, entree.getPrix(), qteInitiale, entree.getIdArticle());

                Entree nextEntree = entreeRepository.get_nextEntree_OnFifo_for_qte(entree.getDateEntree(),sortie.getIdArticle()); 
                entree.setQteEntree(nextEntree.getQteEntree());
                entree.setDateEntree(nextEntree.getDateEntree());
                entree.setPrix(nextEntree.getPrix());
                sortie.setQteSortie(resteForOutput);
                entree.setDateEntree(nextEntree.getDateEntree());
                entree.setId(nextEntree.getId());

                this.getResteForOutput_Fifo(entree, sortie, qteInitiale);

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        if(resteForOutput==0){
            System.out.println("vita calcul");
            System.out.println("Entree now final = "+entree.getQteEntree());
            System.out.println("Sortie now final = "+sortie.getQteSortie());
            System.out.println("Reste a sortir final = "+resteForOutput);

            // entree farany tavela ao anaty base t@
            System.out.println("reste entree = "+(entree.getQteEntree()-sortie.getQteSortie()));
            System.out.println("last entree final = "+entree.getDateEntree());
            // ---------------------------------------------------

            mouvementRepository.createMouvement(entree.getId(), entree.getDateEntree(), entree.getQteEntree(), sortie.getIdSortie(), sortie.getDateSortie(), sortie.getQteSortie(), (entree.getQteEntree()-sortie.getQteSortie()), resteForOutput, entree.getPrix(), qteInitiale, entree.getIdArticle());


        }

    }

    public void getEntreeBySortie_ByIdArticle(Sortie sortie){
        Article articleById = articleRepository.getArticleById(sortie.getIdArticle());
        Mouvement[] mouv2 = null;
        Entree entree2 = new Entree();
        try {
            
            if(articleById.getTypeArticle()==1){
                Entree entree = entreeRepository.get_Last_Entree_OnLifo_ByIdarticle_IdMagasin(sortie.getIdArticle(),sortie.getDateSortie())[0];
                System.out.println("entree for output = "+entree.getIdArticle());
                this.getResteForOutput_Lifo(entree,sortie,sortie.getQteSortie());
                mouv2 = mouvementRepository.get_MouvementFor_OneDateSortie(sortie.getIdArticle(),  sortie.getDateSortie());
                for (int i = 0; i < mouv2.length; i++) {
                    if(mouv2[i].getRestefordate_entree()==0){
                        entree2.setId(mouv2[i].getIdEntree());
                        entreeRepository.deleteEntree(entree2.getId());
                    }
                    else if(mouv2[i].getRestefordate_entree()>0){
                        entree.setId(mouv2[i].getIdEntree());
                        entree.setDateEntree(mouv2[i].getDateget_entree());
                        entree.setIdArticle(mouv2[i].getIdArticle());
                        entree.setPrix(mouv2[i].getPrixEntree());
                        entree.setQteEntree(mouv2[i].getRestefordate_entree());
                        entreeRepository.updateEntree(entree.getId(), entree.getDateEntree(), entree.getIdArticle(),entree.getPrix(), entree.getQteEntree());

                    }
                }
            }
            else if(articleById.getTypeArticle()==0){
                Entree entree = entreeRepository.get_First_Entree_OnFifo_ByIdarticle_IdMagasin(sortie.getIdArticle(),sortie.getDateSortie()).get(0);
                System.out.println("entree for output = "+entree.getIdArticle());
                this.getResteForOutput_Fifo(entree,sortie,sortie.getQteSortie());
                mouv2 = mouvementRepository.get_MouvementFor_OneDateSortie(sortie.getIdArticle(), sortie.getDateSortie());
                for (int i = 0; i < mouv2.length; i++) {
                    if(mouv2[i].getRestefordate_entree()==0){
                        entree2.setId(mouv2[i].getIdEntree());
                        entreeRepository.deleteEntree(entree2.getId());

                    }
                    else if(mouv2[i].getRestefordate_entree()>0){
                        entree.setId(mouv2[i].getIdEntree());
                        entree.setDateEntree(mouv2[i].getDateget_entree());
                        entree.setIdArticle(mouv2[i].getIdArticle());
                        entree.setPrix(mouv2[i].getPrixEntree());
                        entree.setQteEntree(mouv2[i].getRestefordate_entree());
                        entreeRepository.updateEntree(entree.getId(), entree.getDateEntree(), entree.getIdArticle(),entree.getPrix(), entree.getQteEntree());
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Transactional
    public void addSortie(String[] idArticle, double[] qteSortie, Date dateSortie) {
        for (int i = 0; i < idArticle.length; i++) {
            Sortie sortie = new Sortie(); 
            sortie.setIdArticle(idArticle[i]);
            sortie.setQteSortie(qteSortie[i]);
            sortie.setDateSortie(dateSortie);

            System.out.println("id Article = "+sortie.getIdArticle());
            this.getEntreeBySortie_ByIdArticle(sortie);

            repository.createSortie(sortie.getDateSortie(), sortie.getIdArticle(), sortie.getQteSortie());
            repository.flush();
        }
    }
    
}
