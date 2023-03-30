package com.example.neko.Controllers;

import com.example.neko.Models.Filiere;
import com.example.neko.Repository.FiliereRepository;
import com.example.neko.Services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filiere")
public class FiliereController {
    @Autowired
    FiliereRepository filiereRepository;
    @Autowired
    FiliereService filiereService;
    @PostMapping("/creer")
    public Filiere Creer(@RequestBody Filiere filiere){
        return filiereService.Creer(filiere);
    }
    @PutMapping("/modifier/{id}")
    public Filiere Modifier(@PathVariable("id") long id,  @RequestBody Filiere filiere){
        return  filiereService.Modifier(id, filiere);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        filiereService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Filiere getId(@PathVariable("id") long id){
        return  filiereService.GetId(id);
    }
    @GetMapping("/list")
    public List<Filiere> getAll() {
        return  filiereService.getAll();

    }
}
