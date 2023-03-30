package com.example.neko.Controllers;



import com.example.neko.Models.Pubphoto;
import com.example.neko.Repository.PubphotoRepository;
import com.example.neko.Services.PubphotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pubphoto")
public class PubPhotoControlller {
    @Autowired
    PubphotoService pubphotoService;
    @Autowired
    PubphotoRepository pubphotoRepository;

    @PostMapping("/creer")
    public Pubphoto Creer(@RequestBody Pubphoto pubphoto){
        return pubphotoService.Creer(pubphoto);
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
