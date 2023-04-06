package com.example.neko.Services;


import com.example.neko.Models.Commerce;

import java.util.List;

public interface CommerceService {
    Commerce Creer (Commerce commerce);
    Commerce Modifier (long id, Commerce commerce);
    void Supprimer (long id);
    List<Commerce> getAll();
    Commerce GetId(long id);
    Commerce GetByName(String name);
}
