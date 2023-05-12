package com.example.neko.Controllers;


import com.example.neko.Configuration.Image;
import com.example.neko.Models.Annonces;
import com.example.neko.Models.Entreprise;
import com.example.neko.Repository.EntrepriseRepository;
import com.example.neko.Services.EntrepriseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/entreprise")
public class EntrepriseController {
    @Autowired
    EntrepriseService entrepriseService;

    @Autowired
    EntrepriseRepository entrepriseRepository;

    @PostMapping("/creer")
    public ResponseEntity<String> Creer(@RequestParam(value = "data") String entreprise
                                        ) throws JsonProcessingException {
        Entreprise entreprise1 = new Entreprise();
        try{
            entreprise1 = new JsonMapper().readValue(entreprise, Entreprise.class);
            System.out.println("Entreprise "+entreprise1.getDomaine());
            entrepriseService.Creer(entreprise1);
            return ResponseEntity.ok().body("Annonce creer avec succes");

        } catch (Exception e) {
            System.out.println("erreur entreprise ");
            return ResponseEntity.badRequest().body("erreur lors de la creation d'entreprise"+e);
        }

    }

    @PostMapping("/creerentreprise")
    public ResponseEntity<String> EntrepriseCreer(@RequestBody Entreprise entreprise) {
        try{

            entrepriseService.Creer(entreprise);
            System.out.println("email "+entreprise.getEmail());
            return ResponseEntity.ok().body("Entreprise creer avec succes");
        }catch (Exception e) {
            System.out.println("erreur "+e);
            return ResponseEntity.badRequest().body("erreur"+e);
        }


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
