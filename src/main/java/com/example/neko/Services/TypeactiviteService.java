package com.example.neko.Services;


import com.example.neko.Models.Typeactivite;

import java.util.List;

public interface TypeactiviteService {
    Typeactivite Creer (Typeactivite typeactivite);
   Typeactivite Modifier (long id, Typeactivite typeactivite);
    void Supprimer (long id);
    List<Typeactivite> getAll();
    Typeactivite GetId(long id);
    Typeactivite GetByName(String name);
}
