package com.example.neko.Service_Implementation;

import com.example.neko.Models.Filiere;
import com.example.neko.Repository.FiliereRepository;
import com.example.neko.Services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FiliereServiceImplem implements FiliereService {
    @Autowired
    FiliereRepository filiereRepository;
    @Override
    public Filiere Creer(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    @Override
    public Filiere Modifier(long id, Filiere filiere) {
        return filiereRepository.findById(id)
                .map(p->{
                            p.setFiliere(filiere.getFiliere());
                            return filiereRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modication a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        filiereRepository.deleteById(id);

    }

    @Override
    public List<Filiere> getAll() {
        return filiereRepository.findAll();
    }

    @Override
    public Filiere GetId(long id) {
        return filiereRepository.findById(id).get();
    }

    @Override
    public Filiere GetByName(String name) {
        return filiereRepository.findByFiliere(name);
    }
}
