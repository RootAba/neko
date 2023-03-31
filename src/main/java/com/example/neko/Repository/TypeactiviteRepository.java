package com.example.neko.Repository;

import com.example.neko.Models.Typeactivite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeactiviteRepository extends JpaRepository<Typeactivite,Long> {
    Typeactivite findByTypeactivite(String name);
}
