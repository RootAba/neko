package com.example.neko.Services;

import com.example.neko.Models.Pubphoto;

import java.util.List;

public interface PubphotoService {
    Pubphoto Creer (Pubphoto pubphoto);
    Pubphoto Modifier (long id,Pubphoto pubphoto);
    void Supprimer (long id);
    List<Pubphoto> getAll();
    Pubphoto GetId(long id);
    Pubphoto GetByName(String name);
}
