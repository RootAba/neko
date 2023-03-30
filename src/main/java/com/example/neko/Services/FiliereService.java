package com.example.neko.Services;


import com.example.neko.Models.Filiere;
import java.util.List;

public interface FiliereService {
    Filiere Creer (Filiere  filiere);
    Filiere Modifier (long id, Filiere filiere);
    void Supprimer (long id);
    List<Filiere> getAll();
    Filiere GetId(long id);
    Filiere GetByName(String name);
}
