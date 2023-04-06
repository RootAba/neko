package com.example.neko.Controllers;


import com.example.neko.Models.Typeactivite;
import com.example.neko.Repository.TypeactiviteRepository;
import com.example.neko.Services.TypeactiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeactivite")
public class TypeActiviteController {
    @Autowired
    TypeactiviteRepository typeactiviteRepository;
    @Autowired
    TypeactiviteService typeactiviteService;
    @PostMapping("/creer")
    public Typeactivite Creer(@RequestBody Typeactivite typeactivite){
        return typeactiviteService.Creer(typeactivite);
    }
    @PutMapping("/modifier/{id}")
    public Typeactivite Modifier(@PathVariable("id") long id,  @RequestBody Typeactivite typeactivite){
        return  typeactiviteService.Modifier(id, typeactivite);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        typeactiviteService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Typeactivite getId(@PathVariable("id") long id){
        return typeactiviteService.GetId(id);
    }
    @GetMapping("/list")
    public List<Typeactivite> getAll() {
        return  typeactiviteService.getAll();

    }
}
