package com.example.neko.Controllers;

import com.example.neko.Models.Annonces;
import com.example.neko.Models.PubVideo;
import com.example.neko.Repository.PubvideoRepository;
import com.example.neko.Services.PubvideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pubvideo")
public class PubVideoController {
    @Autowired
    PubvideoRepository pubvideoRepository;
    @Autowired
    PubvideoService pubvideoService;
    @PostMapping("/creer")
    public PubVideo Creer(@RequestBody PubVideo pubVideo){
        return pubvideoService.Creer(pubVideo);
    }
    @PutMapping("/modifier/{id}")
    public PubVideo Modifier(@PathVariable("id") long id,  @RequestBody PubVideo pubVideo){
        return  pubvideoService.Modifier(id,pubVideo);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        pubvideoService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public PubVideo getId(@PathVariable("id") long id){
        return  pubvideoService.GetId(id);
    }
    @GetMapping("/list")
    public List<PubVideo> getAll() {
        return  pubvideoService.getAll();

    }
}
