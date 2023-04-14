package com.example.neko.Repository;

import com.example.neko.Models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    //Utilisateur findByUtilisateur(String name);
   // Utilisateur findByUsername(String username);
    Optional<Utilisateur> findByUsername(String username);
    Utilisateur findByNom(String nom);
    Boolean existsByUsername(String username);
    Utilisateur findByEmail(String email);
    Boolean existsByEmail(String email);
}
