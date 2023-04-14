package com.example.neko.Services;

import com.example.neko.Models.Participantappelvideo;

import java.util.List;

public interface ParticipantappelvideoService {
     Participantappelvideo Creer ( Participantappelvideo  participantappelvideo);
     Participantappelvideo Modifier (long id,  Participantappelvideo  participantappelvideo);
    void Supprimer (long id);
    List< Participantappelvideo> getAll();
     Participantappelvideo GetId(long id);
    // Participantappelvideo GetByName(String name);
   
}
