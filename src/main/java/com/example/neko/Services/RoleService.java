package com.example.neko.Services;

import com.example.neko.Models.Roles;

import java.util.List;

public interface RoleService {

    //Creer role
    Roles AjouterRole(Roles role);
    Roles Modifier (int id, Roles roles);
    void Supprimer (int id);
    List<Roles> getAll();
   Roles GetId(int id);
    Roles GetByName(String name);
}
