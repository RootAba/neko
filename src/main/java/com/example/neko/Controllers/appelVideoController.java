package com.example.neko.Controllers;


import com.example.neko.Models.Annonces;
import com.example.neko.Models.Appelvideo;
import com.example.neko.Repository.AppelvideoRepository;
import com.example.neko.Services.AppelvideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appelvideo")
public class appelVideoController {
    @Autowired
    AppelvideoService appelvideoService;
    @Autowired
    AppelvideoRepository appelvideoRepository;
    @PostMapping("/creer")
    public Appelvideo Creer(@RequestBody Appelvideo appelvideo){
        return appelvideoService.Creer(appelvideo);
    }
    @PutMapping("/modifier/{id}")
    public Appelvideo Modifier(@PathVariable("id") long id,  @RequestBody Appelvideo appelvideo){
        return  appelvideoService.Modifier(id, appelvideo);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        appelvideoService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Appelvideo getId(@PathVariable("id") long id){
        return  appelvideoService.GetId(id);
    }
    @GetMapping("/list")
    public List<Appelvideo> getAll() {
        return  appelvideoService.getAll();

    }
}
