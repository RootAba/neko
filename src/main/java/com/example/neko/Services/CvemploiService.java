package com.example.neko.Services;


import com.example.neko.Models.Cvemploi;

import java.util.List;

public interface CvemploiService {
 Cvemploi Creer (Cvemploi cvemploi);
    Cvemploi Modifier (long id, Cvemploi cvemploi);
    void Supprimer (long id);
    List<Cvemploi> getAll();
    Cvemploi GetId(long id);
   Cvemploi GetByName(String name);
}
