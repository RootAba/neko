package com.example.neko.Services;


import com.example.neko.Models.Emploi;

import java.util.List;

public interface EmploiService {
   Emploi Creer (Emploi emploi);
    Emploi Modifier (long id, Emploi emploi);
    void Supprimer (long id);
    List<Emploi> getAll();
    Emploi GetId(long id);
   Emploi GetByName(String name);
}
