package com.example.neko.Services;


import com.example.neko.Models.Chat;

import java.util.List;

public interface ChatService {
   Chat Creer (Chat chat);
    Chat Modifier (long id, Chat chat);
    void Supprimer (long id)
            ;
    List<Chat> getAll();
    Chat GetId(long id);
  //  Chat GetByName(String name);
}
