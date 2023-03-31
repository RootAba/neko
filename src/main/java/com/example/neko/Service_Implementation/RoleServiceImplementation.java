package com.example.neko.Service_Implementation;

import com.example.neko.Models.Roles;
import com.example.neko.Repository.RolesRepository;
import com.example.neko.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImplementation implements RoleService {

    @Autowired
    RolesRepository roleRepository;
    @Override
    public Roles AjouterRole(Roles role) {
        return roleRepository.save(role);
    }

    @Override
    public Roles Modifier(long id, Roles roles) {
        return null;
    }

    @Override
    public void Supprimer(long id) {

    }

    @Override
    public List<Roles> getAll() {
        return null;
    }

    @Override
    public Roles GetId(long id) {
        return null;
    }

    @Override
    public Roles GetByName(String name) {
        return null;
    }
}
