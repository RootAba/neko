package com.example.neko.Services;



import com.example.neko.Models.Appelvideo;

import java.util.List;

public interface AppelvideoService {
    Appelvideo Creer (Appelvideo appelvideo);
    Appelvideo Modifier (long id, Appelvideo appelvideo);
    void Supprimer (long id);
    List<Appelvideo> getAll();
   Appelvideo GetId(long id);
    Appelvideo GetByName(String name);
}
