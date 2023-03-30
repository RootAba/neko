package com.example.neko.Controllers;

import com.example.neko.Models.Emploi;
import com.example.neko.Repository.EmploiRepository;
import com.example.neko.Services.EmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emploi")
public class EmlpoiController {
    @Autowired
    EmploiRepository emploiRepository;
    @Autowired
    EmploiService emploiService;
    @PostMapping("/creer")
    public Emploi Creer(@RequestBody Emploi emploi){
        return emploiService.Creer(emploi);
    }
    @PutMapping("/modifier/{id}")
    public Emploi Modifier(@PathVariable("id") long id,  @RequestBody Emploi emploi){
        return  emploiService.Modifier(id,emploi);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        emploiService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Emploi getId(@PathVariable("id") long id){
        return  emploiService.GetId(id);
    }
    @GetMapping("/list")
    public List<Emploi> getAll() {
        return  emploiService.getAll();

    }
}
