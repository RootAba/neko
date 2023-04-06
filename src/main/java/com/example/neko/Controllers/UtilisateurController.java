package com.example.neko.Controllers;

import com.example.neko.Models.Utilisateur;
import com.example.neko.Repository.UtilisateurRepository;
import com.example.neko.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")



public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    UtilisateurService utilisateurService;
    @PostMapping("/creer")
    public Utilisateur Creer(@RequestBody Utilisateur utilisateur){
        return utilisateurService.Creer(utilisateur);
    }
    @PutMapping("/modifier/{id}")
    public Utilisateur Modifier(@PathVariable("id") long id,  @RequestBody Utilisateur utilisateur){
        return  utilisateurService.Modifier(id, utilisateur);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        utilisateurService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Utilisateur getId(@PathVariable("id") long id){
        return  utilisateurService.GetId(id);
    }
    @GetMapping("/list")
    public List<Utilisateur> getAll() {
        return  utilisateurService.getAll();

    }


}
