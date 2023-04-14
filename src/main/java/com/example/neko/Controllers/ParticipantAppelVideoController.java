package com.example.neko.Controllers;


import com.example.neko.Models. Participantappelvideo;
import com.example.neko.Repository.ParticipantappelvideoRepository;
import com.example.neko.Services.ParticipantappelvideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Paricipant")
public class ParticipantAppelVideoController {
    @Autowired
    ParticipantappelvideoRepository participantappelvideoRepository;
    @Autowired
    ParticipantappelvideoService participantappelvideoService;
    @PostMapping("/creer")
    public  Participantappelvideo Creer(@RequestBody  Participantappelvideo  participantappelvideo){
        return  participantappelvideoService.Creer( participantappelvideo);
    }
    @PutMapping("/modifier/{id}")
    public  Participantappelvideo Modifier(@PathVariable("id") long id,  @RequestBody  Participantappelvideo  participantappelvideo){
        return   participantappelvideoService.Modifier(id,  participantappelvideo);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
         participantappelvideoService.Supprimer(id);
    }
    @GetMapping("/recupParId/{id}")
    public  Participantappelvideo RecupId(@PathVariable("id") long id){
        return   participantappelvideoService.GetId(id);
    }
    @GetMapping("/list")
    public List< Participantappelvideo> getAll() {
        return   participantappelvideoService.getAll();

    }
}
