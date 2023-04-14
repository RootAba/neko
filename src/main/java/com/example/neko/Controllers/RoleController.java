package com.example.neko.Controllers;


import com.example.neko.Models.Roles;
import com.example.neko.Repository.RolesRepository;
import com.example.neko.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    RoleService roleService;
    @PostMapping("/ajouter")
    public Roles Creer(@RequestBody Roles roles){
        return roleService.AjouterRole(roles);
    }
    @PutMapping("/modifier/{id}")
    public Roles Modifier(@PathVariable("id") int id,  @RequestBody Roles roles){
        return  roleService.Modifier(id,roles);
    }
    @DeleteMapping("/supprimer/{id}")
    void  Supprimer(@PathVariable("id") int id ){
       roleService.Supprimer(id);
    }
    @GetMapping("/get/{id}")
    public Roles getId(@PathVariable("id") int id){
        return  roleService.GetId(id);
    }
    @GetMapping("/list")
    public List<Roles> getAll() {
        return  roleService.getAll();

    }

}
