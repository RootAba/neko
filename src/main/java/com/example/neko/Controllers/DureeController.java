package com.example.neko.Controllers;


import com.example.neko.Models.Annonces;
import com.example.neko.Models.Duree;
import com.example.neko.Repository.DureeRepository;
import com.example.neko.Services.DureeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/duree")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8100"} ,allowCredentials = "true",maxAge = 3600)
public class DureeController {
    @Autowired
    DureeService dureeService;
    @Autowired
    DureeRepository dureeRepository;
    @PostMapping("/creer")
    public Duree Creer(@RequestBody Duree duree){
        return dureeService.Creer(duree);
    }
    @PutMapping("/modifier/{id}")
    public Duree Modifier(@PathVariable("id") long id,  @RequestBody Duree duree){
        return dureeService.Modifier(id, duree);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        dureeService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Duree getId(@PathVariable("id") long id){
        return  dureeService.GetId(id);
    }
    @GetMapping("/list")
    public List<Duree> getAll() {
        return  dureeService.getAll();

    }
}
