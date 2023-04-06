package com.example.neko.Services;

import com.example.neko.Models.Pubaudio;

import java.util.List;

public interface PubaudioService {
    Pubaudio Creer (Pubaudio pubaudio);
    Pubaudio Modifier (long id, Pubaudio pubaudio);
    void Supprimer (long id);
    List<Pubaudio> getAll();
    Pubaudio GetId(long id);
    Pubaudio GetByName(String name);
}
