package com.example.neko.Controllers;

import com.example.neko.Configuration.Image;
import com.example.neko.Models.Annonces;
import com.example.neko.Repository.AnnonceRepository;
import com.example.neko.Services.AnnoncesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8100"} ,allowCredentials = "true")
@RequestMapping("/annonce")

public class AnnoncesController {
    @Autowired
    AnnoncesService annoncesService;
    @Autowired
    AnnonceRepository annonceRepository;
    @PostMapping("/creer")
    public ResponseEntity<String> Creer(@RequestParam(value = "data") String annonces,
                                        @RequestParam(value = "file", required = false)
                                        MultipartFile file) throws JsonProcessingException {
        Annonces annonces1 = new Annonces();
        try{
            if (file != null) {
                System.out.println("ggggg");
                annonces1 = new JsonMapper().readValue(annonces, Annonces.class);
                System.out.println("Annonces "+annonces1.getAnnonce());

                annonces1.setImage(Image.save("publications", file, annonces1.getImage()));
                annoncesService.Creer(annonces1);
                return ResponseEntity.ok().body("Annonce creer avec succes");
                // entite.setImage(SaveImage.save("activite", file, entite.getLibelleentite()));
            }else{
                annonces1.setImage("");
                annoncesService.Creer(annonces1);
                return ResponseEntity.ok().body("Annonce creer avec succes");
            }
        }catch (Exception e) {
            System.out.println("erreur annonce "+annonces1.getAnnonce());
            return ResponseEntity.badRequest().body("erreur lors de la creation d'annonce"+e);
        }

    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<String> Modifier(@PathVariable("id") long id, @RequestParam(value = "data") String annonces,
                                           @RequestParam(value = "file", required = false) MultipartFile file) throws JsonProcessingException{
        Annonces annonces1 = null;
        try{
            if (file != null) {
                System.out.println("ggggg");
                annonces1 = new JsonMapper().readValue(annonces, Annonces.class);
                System.out.println("Annonces "+annonces1.getAnnonce());

                annonces1.setImage(Image.save("publications", file, annonces1.getImage()));
                annoncesService.Modifier(id,annonces1);
                return ResponseEntity.ok().body("Annonce Modifier avec succes");
                // entite.setImage(SaveImage.save("activite", file, entite.getLibelleentite()));
            }else{
                annonces1.setImage("");
                annoncesService.Modifier(id,annonces1);
                return ResponseEntity.ok().body("Annonce Modifier avec succes");
            }
        }catch (Exception e) {
            System.out.println("erreur annonce "+annonces1.getAnnonce());
            return ResponseEntity.badRequest().body("erreur lors de la creation d'annonce"+e);
        }

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
