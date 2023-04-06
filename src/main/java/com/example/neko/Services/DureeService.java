package com.example.neko.Services;



import com.example.neko.Models.Duree;

import java.util.List;

public interface DureeService {
    Duree Creer (Duree duree);
    Duree Modifier (long id, Duree duree);
    void Supprimer (long id);
    List<Duree> getAll();
    Duree GetId(long id);
    Duree GetByName(String name);
}
