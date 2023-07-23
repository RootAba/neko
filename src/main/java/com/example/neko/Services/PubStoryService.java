package com.example.neko.Services;

import com.example.neko.Models.PubStory;
import com.example.neko.Models.Pubphoto;

import java.util.List;

public interface PubStoryService {

    PubStory Creer (PubStory pubStory);
    PubStory Modifier (long id,PubStory pubstory);
    void Supprimer (long id);
    List<PubStory> getAll();
    PubStory GetId(long id);
    //Pubphoto GetByName(String name);
}
