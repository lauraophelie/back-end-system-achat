package com.systeme.commercial.repository;

import com.systeme.commercial.model.Bon_commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonCommandeRepository extends JpaRepository<Bon_commande, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}
