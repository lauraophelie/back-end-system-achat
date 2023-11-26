package com.systeme.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.systeme.commercial.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email AND u.password = :password")
    public Utilisateur findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
