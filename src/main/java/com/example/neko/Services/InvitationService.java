package com.example.neko.Services;

import com.example.neko.Models.Invitations;

import java.util.List;

public interface InvitationService {
    Invitations Creer (Invitations invitation);
    Invitations Modifier (long id, Invitations invitation);
    void Supprimer (long id);
    List<Invitations> getAll();
    Invitations GetId(long id);
   // Invitations GetByName(String name);
}
