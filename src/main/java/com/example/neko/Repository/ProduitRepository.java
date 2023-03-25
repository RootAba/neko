package com.example.neko.Repository;

import com.example.neko.Models.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produits,Integer> {
}
