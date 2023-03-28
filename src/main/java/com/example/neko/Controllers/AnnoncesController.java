package com.example.neko.Controllers;

import com.example.neko.Models.Annonces;
import com.example.neko.Repository.AnnonceRepository;
import com.example.neko.Services.AnnoncesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonce")
public class AnnoncesController {
    @Autowired
    AnnoncesService annoncesService;
    @Autowired
    AnnonceRepository annonceRepository;
    @PostMapping("/creer")
    public Annonces Creer(@RequestBody Annonces annonces){
        return annoncesService.Creer(annonces);
    }
    @PutMapping("/modifier/{id}")
    public Annonces Modifier(@PathVariable("id") long id,  @RequestBody Annonces annonces){
        return  annoncesService.Modifier(id, annonces);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        annoncesService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Annonces getId(@PathVariable("id") long id){
        return  annoncesService.GetId(id);
    }
    @GetMapping("/list")
    public List<Annonces> getAll() {
        return  annoncesService.getAll();

    }
}
