package com.example.neko.Repository;

import com.example.neko.Models.Cvemploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvemploiRepository extends JpaRepository<Cvemploi,Long> {
  //  Cvemploi findByCvemploi(String name);
}
