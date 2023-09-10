package com.example.neko.Controllers;

import com.example.neko.Models.Utilisateur;
import com.example.neko.Repository.UtilisateurRepository;
import com.example.neko.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/utilisateur")

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8100"} ,allowCredentials = "true",maxAge = 3600)


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

  /*  @GetMapping("/list/{utilisateur}")
    public List<Utilisateur> rechercherUtilisateur(@PathVariable String utilisateur) {
        return  utilisateurService.rechercherUtilisateur(utilisateur);

    }*/
    @GetMapping("/list/{nom}")
    public List<Utilisateur> rechercherUtilisateursParNom(@PathVariable String nom) {
        // Récupérer tous les utilisateurs de la base de données
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();

        // Filtrer les utilisateurs en fonction du nom passé en paramètre
        List<Utilisateur> utilisateursFiltres = utilisateurs.stream()
                .filter(user -> user.getNom().matches("(?i).*" + nom + ".*") ||
                        user.getUsername().matches("(?i).*" + nom + ".*"))
                .collect(Collectors.toList());
   System.out.println("liste des users ");
   System.out.println(utilisateursFiltres);
        return utilisateursFiltres;
    }


}
