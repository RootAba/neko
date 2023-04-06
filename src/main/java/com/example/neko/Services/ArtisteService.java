package com.example.neko.Services;


import com.example.neko.Models.Artiste;

import java.util.List;

public interface ArtisteService {
    Artiste Creer (Artiste artiste);
   Artiste Modifier (long id, Artiste artiste);
    void Supprimer (long id);
    List<Artiste> getAll();
    Artiste GetId(long id);
    Artiste GetByName(String name);
}
