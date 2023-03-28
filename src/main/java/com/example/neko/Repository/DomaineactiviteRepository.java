package com.example.neko.Repository;

import com.example.neko.Models.Domaineactivite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineactiviteRepository extends JpaRepository<Domaineactivite,Long> {
    Domaineactivite findByDomaine(String name);
}
