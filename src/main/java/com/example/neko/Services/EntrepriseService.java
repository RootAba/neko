package com.example.neko.Services;



import com.example.neko.Models.Entreprise;

import java.util.List;

public interface EntrepriseService {
    Entreprise Creer (Entreprise entreprise);
    Entreprise Modifier (long id,  Entreprise entreprise);
    void Supprimer (long id);
    List<Entreprise> getAll();
    Entreprise GetId(long id);
    Entreprise GetByName(String name);
}
