package com.example.neko.Controllers;


import com.example.neko.Models.Cvemploi;
import com.example.neko.Repository.CvemploiRepository;
import com.example.neko.Services.CvemploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cvemploi")
public class CvEmploiController {
    @Autowired
    CvemploiService cvemploiService;
    @Autowired
    CvemploiRepository cvemploiRepository;

    @PostMapping("/creer")
    public Cvemploi Creer(@RequestBody Cvemploi cvemploi) {
        return cvemploiService.Creer(cvemploi);
    }

    @PutMapping("/modifier/{id}")
    public Cvemploi Modifier(@PathVariable("id") long id, @RequestBody Cvemploi cvemploi) {
        return cvemploiService.Modifier(id, cvemploi);
    }

    @DeleteMapping("/supprimer/{id}")
    void Supprimer(@PathVariable("id") long id) {
        cvemploiService.Supprimer(id);
    }

    @GetMapping("/get/{id}")
    public Cvemploi getId(@PathVariable("id") long id) {
        return cvemploiService.GetId(id);
    }

    @GetMapping("/list")
    public List<Cvemploi> getAll() {
        return cvemploiService.getAll();
    }
}
