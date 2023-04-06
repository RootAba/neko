package com.example.neko.Controllers;



import com.example.neko.Models.Commerce;
import com.example.neko.Repository.CommerceRepository;
import com.example.neko.Services.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commerce")
public class CommerceController {
    @Autowired
    CommerceService commerceService;
    @Autowired
    CommerceRepository commerceRepository;

    @PostMapping("/creer")
    public Commerce Creer(@RequestBody Commerce commerce) {
        return commerceService.Creer(commerce);
    }

    @PutMapping("/modifier/{id}")
    public Commerce Modifier(@PathVariable("id") long id, @RequestBody Commerce commerce) {
        return commerceService.Modifier(id, commerce);
    }

    @DeleteMapping("/supprimer/{id}")
    void Supprimer(@PathVariable("id") long id) {
        commerceService.Supprimer(id);
    }

    @GetMapping("/get/{id}")
    public Commerce getId(@PathVariable("id") long id) {
        return commerceService.GetId(id);
    }

    @GetMapping("/list")
    public List<Commerce> getAll() {
        return commerceService.getAll();
    }
}
