package com.example.neko.Controllers;



import com.example.neko.Configuration.Image;
import com.example.neko.Models.Annonces;
import com.example.neko.Models.Pubphoto;
import com.example.neko.Repository.PubphotoRepository;
import com.example.neko.Services.PubphotoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/pubphoto")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8100"} ,allowCredentials = "true",maxAge = 3600)
public class PubPhotoControlller {
    @Autowired
    PubphotoService pubphotoService;
    @Autowired
    PubphotoRepository pubphotoRepository;

    @PostMapping("/creer")
    public ResponseEntity<String> Creer(@RequestParam(value = "data") String pubphoto,
                          @RequestParam(value = "file", required = false)
                          MultipartFile file) throws JsonProcessingException {
        Pubphoto pubphoto1 = new Pubphoto();
        try{
            if (file != null) {
                System.out.println("ggggg");
                pubphoto1 = new JsonMapper().readValue(pubphoto, Pubphoto.class);
                System.out.println("PubPhoto "+pubphoto1.getPhoto());

                pubphoto1.setPhoto(Image.save("publications", file, pubphoto1.getPhoto()));
                pubphotoService.Creer(pubphoto1);
                return ResponseEntity.ok().body("publications photo creer avec succes");
                // entite.setImage(SaveImage.save("activite", file, entite.getLibelleentite()));
            }else{
                pubphoto1.setPhoto("");
                pubphotoService.Creer(pubphoto1);
                return ResponseEntity.ok().body("publications creer avec succes");
            }
        }catch (Exception e) {
            System.out.println("erreur annonce "+pubphoto1.getNom());
            return ResponseEntity.badRequest().body("erreur lors de la creation d'pubphoto"+e);
        }

        //return pubphotoService.Creer(pubphoto);
    }
    @PutMapping("/modifier/{id}")
    public Pubphoto Modifier(@PathVariable("id") long id,  @RequestBody Pubphoto pubphoto){
        return  pubphotoService.Modifier(id, pubphoto);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        pubphotoService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Pubphoto getId(@PathVariable("id") long id){
        return  pubphotoService.GetId(id);
    }
    @GetMapping("/list")
    public List<Pubphoto> getAll() {
        return  pubphotoService.getAll();

    }
}
