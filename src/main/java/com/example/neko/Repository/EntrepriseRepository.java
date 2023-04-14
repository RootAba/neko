package com.example.neko.Repository;

import com.example.neko.Models.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {
    Entreprise findByDomaine(String domaine);
}
