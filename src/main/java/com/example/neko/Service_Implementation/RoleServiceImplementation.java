package com.example.neko.Service_Implementation;

import com.example.neko.Models.Roles;
import com.example.neko.Repository.RolesRepository;
import com.example.neko.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplementation implements RoleService {

    @Autowired
    RolesRepository roleRepository;
    @Override
    public Roles AjouterRole(Roles role) {
        return roleRepository.save(role);
    }
}
