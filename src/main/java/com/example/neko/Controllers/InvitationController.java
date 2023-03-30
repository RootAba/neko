package com.example.neko.Controllers;


import com.example.neko.Models.Invitations;
import com.example.neko.Repository.InvitationRepository;
import com.example.neko.Services.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class InvitationController {
    @Autowired
    InvitationService invitationService;
    @Autowired
    InvitationRepository invitationRepository;
    @PostMapping("/creer")
    public Invitations Creer(@RequestBody Invitations invitations){
        return invitationService.Creer(invitations);
    }
    @PutMapping("/modifier/{id}")
    public Invitations Modifier(@PathVariable("id") long id,  @RequestBody Invitations invitations){
        return  invitationService.Modifier(id, invitations);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") long id ){
        invitationService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Invitations getId(@PathVariable("id") long id){
        return  invitationService.GetId(id);
    }
    @GetMapping("/list")
    public List<Invitations> getAll() {
        return invitationService.getAll();

    }
}
