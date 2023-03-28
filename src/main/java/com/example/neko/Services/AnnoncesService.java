package com.example.neko.Services;

import com.example.neko.Models.Annonces;

import java.util.List;

public interface AnnoncesService {
    Annonces Creer (Annonces annonces);
    Annonces Modifier (long id, Annonces annonces);
    void Supprimer (long id);
    List<Annonces> getAll();
    Annonces GetId(long id);
    Annonces GetByName(String name);
}
