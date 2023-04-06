package com.example.neko.Services;

import com.example.neko.Models.PubVideo;

import java.util.List;

public interface PubvideoService {
   PubVideo Creer (PubVideo pubVideo);
    PubVideo Modifier (long id, PubVideo pubVideo);
    void Supprimer (long id);
    List<PubVideo> getAll();
    PubVideo GetId(long id);
    PubVideo GetByName(String name);
}
