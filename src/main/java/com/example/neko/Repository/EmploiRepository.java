package com.example.neko.Repository;

import com.example.neko.Models.Emploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploiRepository extends JpaRepository<Emploi,Long> {
    Emploi findByEmploi(String name);
}
