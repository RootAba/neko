package com.example.neko.Services;

import com.example.neko.Models.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur Creer (Utilisateur utilisateur);
    Utilisateur Modifier (long id, Utilisateur utilisateur);
    void Supprimer (long id);
    List<Utilisateur> getAll();
    Utilisateur GetId(long id);
    Utilisateur GetByName(String name);
}
