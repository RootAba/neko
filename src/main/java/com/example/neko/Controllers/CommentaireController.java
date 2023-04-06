package com.example.neko.Controllers;


import com.example.neko.Models.Commentaires;
import com.example.neko.Repository.CommentaireRepository;
import com.example.neko.Services.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaire")
public class CommentaireController {
    @Autowired
    CommentaireService commentaireService;
    @Autowired
    CommentaireRepository commentaireRepository;

    @PostMapping("/creer")
    public Commentaires Creer(@RequestBody Commentaires commentaires) {
        return commentaireService.Creer(commentaires);
    }

    @PutMapping("/modifier/{id}")
    public Commentaires Modifier(@PathVariable("id") long id, @RequestBody Commentaires commentaires) {
        return commentaireService.Modifier(id, commentaires);
    }

    @DeleteMapping("/supprimer/{id}")
    void Supprimer(@PathVariable("id") long id) {
       commentaireService.Supprimer(id);
    }

    @GetMapping("/get/{id}")
    public Commentaires getId(@PathVariable("id") long id) {
        return commentaireService.GetId(id);
    }

    @GetMapping("/list")
    public List<Commentaires> getAll() {
        return commentaireService.getAll();
    }
}
