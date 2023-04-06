package com.example.neko.Services;

import com.example.neko.Models.Domaineactivite;

import java.util.List;

public interface DomaineactiviteService {
    Domaineactivite Creer(Domaineactivite domaineactivite );
   Domaineactivite Modifier (long id,Domaineactivite domaineactivite);
    void Supprimer(long id);
    List<Domaineactivite> getAll();
    Domaineactivite GetId(long id);
    Domaineactivite GetByName(String name);
}
