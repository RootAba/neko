package com.example.neko.Controllers;

import com.example.neko.Models.Produits;
import com.example.neko.Repository.ProduitRepository;
import com.example.neko.Services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class ProduitController {
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    ProduitService produitService;
    @PostMapping("/creer")
    public Produits Creer(@RequestBody Produits produits){
        return produitService.Creer(produits);
    }
    @PutMapping("/modifier/{id}")
    public Produits Modifier(@PathVariable("id") int id,  @RequestBody Produits produits){
        return  produitService.Modifier(id, produits);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") int id ){
        produitService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Produits getId(@PathVariable("id") int id){
        return  produitService.GetId(id);
    }
    @GetMapping("/list")
    public List<Produits> getAll() {
        return  produitService.getAll();

    }
}
