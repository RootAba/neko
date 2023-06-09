package com.example.neko.Service_Implementation;

import com.example.neko.Models.ERole;
import com.example.neko.Models.Roles;
import com.example.neko.Repository.RolesRepository;
import com.example.neko.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImplementation implements RoleService {

    @Autowired
    RolesRepository roleRepository;
    @Override
    public Roles AjouterRole(Roles role) {
        return roleRepository.save(role);
    }

    @Override
    public Roles Modifier(int id, Roles roles) {
        return roleRepository.findById(id)
                .map(p->{
                            p.setName(roles.getName());
                            return roleRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modification a echoué"));
    }

    @Override
    public void Supprimer(int id) {
        roleRepository.deleteById(id);

    }

    @Override
    public List<Roles> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Roles GetId(int id) {
      return roleRepository.findById(id).get();
    }

    @Override
    public Optional<Roles> AfficherRoleParLibelle(ERole libelle) {
        return roleRepository.findByName(libelle);
    }


  /*  @Override
    public Optional<Roles> GetByName(String name) {
        return  roleRepository.findByName(name);
    }*/
}
