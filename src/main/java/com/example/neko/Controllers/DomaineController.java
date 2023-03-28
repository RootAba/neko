package com.example.neko.Controllers;
import com.example.neko.Models.Domaineactivite;
import com.example.neko.Repository.DomaineactiviteRepository;
import com.example.neko.Services.DomaineactiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domaine")

public class DomaineController {
    @Autowired
    DomaineactiviteService domaineactiviteService;
    @Autowired
    DomaineactiviteRepository domaineactiviteRepository;
    @PostMapping("/creer")
    public Domaineactivite Creer(@RequestBody Domaineactivite domaineactivite){
        return domaineactiviteService.Creer(domaineactivite);
    }
    @PutMapping("/modifier/{id}")
    public Domaineactivite Modifier(@PathVariable("id") long id,  @RequestBody Domaineactivite domaineactivite){
        return  domaineactiviteService.Modifier(id, domaineactivite);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        domaineactiviteService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Domaineactivite getId(@PathVariable("id") long id){
        return  domaineactiviteService.GetId(id);
    }
    @GetMapping("/list")
    public List<Domaineactivite> getAll() {
        return  domaineactiviteService.getAll();

    }



}

