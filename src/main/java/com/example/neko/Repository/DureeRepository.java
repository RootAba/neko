package com.example.neko.Repository;

import com.example.neko.Models.Duree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DureeRepository extends JpaRepository<Duree,Long> {


    Duree findByDuree(String name);
}
