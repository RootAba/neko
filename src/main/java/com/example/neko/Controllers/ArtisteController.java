package com.example.neko.Controllers;



import com.example.neko.Models.Artiste;
import com.example.neko.Repository.ArtisteRepository;
import com.example.neko.Services.ArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/artiste")
public class ArtisteController {
    @Autowired
    ArtisteService artisteService;
    @Autowired
    ArtisteRepository artisteRepository;

    @PostMapping("/creer")
    public Artiste Creer(@RequestBody Artiste artiste) {
        return artisteService.Creer(artiste);
    }

    @PutMapping("/modifier/{id}")
    public Artiste Modifier(@PathVariable("id") long id, @RequestBody Artiste artiste) {
        return artisteService.Modifier(id, artiste);
    }

    @DeleteMapping("/supprimer/{id}")
    void Supprimer(@PathVariable("id") long id) {
        artisteService.Supprimer(id);
    }

    @GetMapping("/recup/{id}")
    public Artiste RecupParId(@PathVariable("id") long id) {
        return artisteService.GetId(id);
    }

    @GetMapping("/list")
    public List<Artiste> getAll() {
        return artisteService.getAll();
    }
}
