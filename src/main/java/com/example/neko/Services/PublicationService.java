package com.example.neko.Services;

import com.example.neko.Models.Publications;

import java.util.List;

public interface PublicationService {
    Publications Creer (Publications publications);
    Publications Modifier (long id, Publications publications);
    void Supprimer (long id);
    List<Publications> getAll();
    Publications GetId(long id);
    Publications GetByName(String name);
}
