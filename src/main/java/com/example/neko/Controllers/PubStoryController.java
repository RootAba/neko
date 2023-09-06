package com.example.neko.Controllers;


import com.example.neko.Configuration.Image;
import com.example.neko.Models.PubStory;
import com.example.neko.Models.Pubphoto;
import com.example.neko.Repository.PubStoryRepository;
import com.example.neko.Services.PubStoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/pubstory")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8100"} ,allowCredentials = "true",maxAge = 3600)
public class PubStoryController {
    @Autowired
    private PubStoryService pubStoryService;

    @Autowired
    private PubStoryRepository pubStoryRepository;

    @PostMapping("/creer")
    public ResponseEntity<String> Creer(@RequestParam(value = "data") String pubstory,
                                        @RequestParam(value = "file", required = false)
                                        MultipartFile file) throws JsonProcessingException {
        PubStory pubstory1 = new PubStory();
        try{
            if (file != null) {
                System.out.println("ggggg");
                pubstory1 = new JsonMapper().readValue(pubstory, PubStory.class);
                System.out.println("PubPhoto "+pubstory1.getStory());

                pubstory1.setStory(Image.save("stories", file, pubstory1.getStory()));
                System
                        .out.println("user "+pubstory1.getUtilisateur());
                pubStoryService.Creer(pubstory1);
                return ResponseEntity.ok().body("publications photo creer avec succes");
                // entite.setImage(SaveImage.save("activite", file, entite.getLibelleentite()));
            }else{
                pubstory1.setStory("");
                pubStoryService.Creer(pubstory1);
                return ResponseEntity.ok().body("publications creer avec succes");
            }
        }catch (Exception e) {
            System.out.println("erreur annonce "+pubstory1.getNom());
            return ResponseEntity.badRequest().body("erreur lors de la creation d'pubstory"+e);
        }

        //return pubphotoService.Creer(pubphoto);
    }


    @PutMapping("/modifier/{id}")
    public PubStory Modifier(@PathVariable("id") long id,  @RequestBody PubStory pubstory){
        return  pubStoryService.Modifier(id, pubstory);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        pubStoryService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public PubStory getId(@PathVariable("id") long id){
        return  pubStoryService.GetId(id);
    }
    @GetMapping("/list")
    public List<PubStory> getAll() {
        return  pubStoryService.getAll();

    }

}
