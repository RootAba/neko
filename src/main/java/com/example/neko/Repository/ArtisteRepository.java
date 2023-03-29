package com.example.neko.Repository;

import com.example.neko.Models.Artiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtisteRepository extends JpaRepository<Artiste,Long> {
    Artiste findByArtiste(String name);
}
