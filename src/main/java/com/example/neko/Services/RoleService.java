package com.example.neko.Services;

import com.example.neko.Models.Roles;

import java.util.List;

public interface RoleService {

    //Creer role
    Roles AjouterRole(Roles role);
    Roles Modifier (long id, Roles roles);
    void Supprimer (long id);
    List<Roles> getAll();
   Roles GetId(long id);
    Roles GetByName(String name);
}
