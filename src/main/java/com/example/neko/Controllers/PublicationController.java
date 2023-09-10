package com.example.neko.Controllers;

import com.example.neko.Models.Publications;
import com.example.neko.Models.Utilisateur;
import com.example.neko.Repository.PublicationRepository;
import com.example.neko.Services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/publication")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8100"} ,allowCredentials = "true",maxAge = 3600)
public class PublicationController {
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    PublicationService publicationService;
    @PostMapping("/creer")
    public Publications Creer(@RequestBody Publications publications){
        return publicationService.Creer(publications);
    }
    @PutMapping("/modifier/{id}")
    public Publications Modifier(@PathVariable("id") long id,  @RequestBody Publications publications){
        return  publicationService.Modifier(id, publications);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        publicationService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Publications getId(@PathVariable("id") long id){
        return  publicationService.GetId(id);
    }
    @GetMapping("/list")
    public List<Publications> getAll() {
        return  publicationService.getAll();

    }
/*
    @GetMapping("/list/{nom}")
    public List<Publications> rechercherPublicationParNom(@PathVariable String nom) {
        // Récupérer tous les utilisateurs de la base de données
        List<Publications> publications = publicationRepository.findAll();

        // Filtrer les utilisateurs en fonction du nom passé en paramètre
        List<Publications> publicationFiltres = publications.stream()
                .filter(publications1 -> publications1.getNom().matches("(?i).*" + nom + ".*") ||
                        publications1.getDescription().matches("(?i).*" + nom + ".*") ||
                        publications1.getUtilisateur().getNom().matches("(?i).*" + nom + ".*"))
                .collect(Collectors.toList());
        System.out.println("liste des publication ");
        System.out.println(publicationFiltres);
        return publicationFiltres;
    }*/
@GetMapping("/list/{nom}")
public List<Publications> rechercherPublicationParNom(@PathVariable String nom) {
    // Récupérer toutes les publications de la base de données
    List<Publications> publications = publicationRepository.findAll();

    // Filtrer les publications en fonction du nom passé en paramètre
    List<Publications> publicationFiltres = publications.stream()
            .filter(publications1 -> {
                String description = publications1.getDescription();
                String publicationNom = publications1.getNom();
              //  String utilisateurNom = publications1.getUtilisateur().getNom();

                // Vérifier si le nom ou la description sont vides ou null
                boolean nomNonVide = publicationNom != null && !publicationNom.isEmpty();
                boolean descriptionNonVide = description != null && !description.isEmpty();
             //   boolean utilisateurNomNonVide = utilisateurNom != null && !utilisateurNom.isEmpty();

                // Retourner true si au moins un des champs correspond au nom recherché et n'est pas vide ou null
                return (nomNonVide && publicationNom.matches("(?i).*" + nom + ".*")) ||
                        (descriptionNonVide && description.matches("(?i).*" + nom + ".*")) ;
                        //(utilisateurNomNonVide && utilisateurNom.matches("(?i).*" + nom + ".*"));
            })
            .collect(Collectors.toList());

    System.out.println("Liste des publications dont la description ou le nom de l'utilisateur contient '" + nom + "' : ");
    System.out.println(publicationFiltres);

    return publicationFiltres;
}


}
