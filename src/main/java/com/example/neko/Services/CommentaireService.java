package com.example.neko.Services;



import com.example.neko.Models.Commentaires;
import com.example.neko.Models.Publications;

import java.util.List;

public interface CommentaireService {
   Commentaires Creer (Commentaires commentaires);
    Commentaires Modifier (long id, Commentaires commentaires);
    void Supprimer (long id);
    List<Commentaires> getAll();
    Commentaires GetId(long id);

    List<Commentaires> getAllByIdPub(Publications publications);
  // Commentaires GetByName(String name);
}
