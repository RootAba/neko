package com.example.neko.Repository;

import com.example.neko.Models.Annonces;
import com.example.neko.Models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonces,Long> {
    Annonces findByAnnonce(String name);
}
