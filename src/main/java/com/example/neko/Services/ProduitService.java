package com.example.neko.Services;

import com.example.neko.Models.Produits;

import java.util.List;

public interface ProduitService {
     Produits Creer ( Produits  produit);
     Produits Modifier (int id,  Produits  produit);
    void Supprimer (int id);
    List< Produits> getAll();
     Produits GetId(int id);
     Produits GetByName(String name);
}
