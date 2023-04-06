package com.example.neko.Controllers;

import com.example.neko.Models.Publications;
import com.example.neko.Repository.PublicationRepository;
import com.example.neko.Services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publication")
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

}
