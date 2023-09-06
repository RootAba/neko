package com.example.neko.Controllers;



import com.example.neko.Models.Pubaudio;
import com.example.neko.Repository.PubaudioRepository;
import com.example.neko.Services.PubaudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pubaudio")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8100"} ,allowCredentials = "true")
public class PubAudioController {
    @Autowired
    PubaudioRepository pubaudioRepository;
    @Autowired
    PubaudioService pubaudioService;
    @PostMapping("/creer")
    public Pubaudio Creer(@RequestBody Pubaudio pubaudio){
        return pubaudioService.Creer(pubaudio);
    }
    @PutMapping("/modifier/{id}")
    public Pubaudio Modifier(@PathVariable("id") long id,  @RequestBody Pubaudio pubaudio){
        return pubaudioService.Modifier(id, pubaudio);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        pubaudioService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Pubaudio getId(@PathVariable("id") long id){
        return  pubaudioService.GetId(id);
    }
    @GetMapping("/list")
    public List<Pubaudio> getAll() {
        return  pubaudioService.getAll();

    }
}
