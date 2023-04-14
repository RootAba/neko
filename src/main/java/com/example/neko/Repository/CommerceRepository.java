package com.example.neko.Repository;

import com.example.neko.Models.Commerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommerceRepository extends JpaRepository<Commerce,Long> {
    Commerce findByNom(String name);
}
