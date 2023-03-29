package com.example.neko.Controllers;


import com.example.neko.Models.Entreprise;
import com.example.neko.Repository.EntrepriseRepository;
import com.example.neko.Services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprise")
public class EntrepriseController {
    @Autowired
    EntrepriseService entrepriseService;

    @Autowired
    EntrepriseRepository entrepriseRepository;
    @PostMapping("/creer")
    public Entreprise Creer(@RequestBody Entreprise entreprise) {
        return entrepriseService.Creer(entreprise);
    }

    @PutMapping("/modifier/{id}")
    public Entreprise Modifier(@PathVariable("id") long id, @RequestBody Entreprise entreprise) {
        return entrepriseService.Modifier(id, entreprise);
    }

    @DeleteMapping("/supprimer/{id}")
    void Supprimer(@PathVariable("id") long id) {
        entrepriseService.Supprimer(id);
    }

    @GetMapping("/get/{id}")
    public Entreprise getId(@PathVariable("id") long id) {
        return entrepriseService.GetId(id);
    }

    @GetMapping("/list")
    public List<Entreprise> getAll() {
        return entrepriseService.getAll();
    }

}
