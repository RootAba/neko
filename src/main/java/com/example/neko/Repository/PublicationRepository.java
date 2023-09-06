package com.example.neko.Repository;

import com.example.neko.Models.Publications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publications,Long> {
    //SELECT * FROM `publication` WHERE publication.description LIKE '%publication%' or  publication.nom LIKE '%publication%';
    Publications findByNom(String name);
/*
  @Query("SELECT * FROM publication WHERE publication.description LIKE :%nom% or  publication.nom LIKE :%nom%", nativeQuery = true)
    List<Publications> RecherchePublication(@PathVariable String nom);*/

    @Query(value = "SELECT * FROM publication WHERE publication.description LIKE %:nom% OR publication.nom LIKE %:nom%", nativeQuery = true)
    List<Publications> recherchePublication(@PathVariable String nom);

}
