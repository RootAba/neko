package com.example.neko.Service_Implementation;

import com.example.neko.Models.ERole;
import com.example.neko.Models.Entreprise;
import com.example.neko.Models.Roles;
import com.example.neko.Repository.EntrepriseRepository;
import com.example.neko.Repository.RolesRepository;
import com.example.neko.Services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    EntrepriseRepository entrepriseRepository;
    public Entreprise Creer(Entreprise entreprise) {
        Roles userRole = rolesRepository.findByName(ERole.ROLE_ENTREPRISE)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Set<Roles> roles = new HashSet<>();
        roles.add(userRole);
        entreprise.setRoles(roles);
        entreprise.setPassword( encoder.encode(entreprise.getPassword()));
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public Entreprise Modifier(long id, Entreprise entreprise) {
        return entrepriseRepository.findById(id)
                .map(p->{
                            p.setDomaine(entreprise.getDomaine());
                            return entrepriseRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modification a echoué"));
    }


    @Override
    public void Supprimer(long id) {
        entrepriseRepository.deleteById(id);

    }

    @Override
    public List<Entreprise> getAll() {
        return entrepriseRepository.findAll();
    }

    @Override
    public Entreprise GetId(long id) {
        return entrepriseRepository.findById(id).get();
    }

    @Override
    public Entreprise GetByDomaine(String name) {
        return entrepriseRepository.findByDomaine(name);
    }


}
