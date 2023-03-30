package com.example.neko.Service_Implementation;

import com.example.neko.Models.Duree;
import com.example.neko.Repository.DureeRepository;
import com.example.neko.Services.DureeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DureeServiceImplem implements DureeService {
    @Autowired
    DureeRepository dureeRepository;

    @Override
    public Duree Creer(Duree duree) {
        return dureeRepository.save(duree);
    }

    @Override
    public Duree Modifier(long id, Duree duree) {
        return dureeRepository.findById(id)
                .map(p->{
                            p.setDuree(duree.getDuree());
                            return dureeRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modication a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        dureeRepository.deleteById(id);

    }

    @Override
    public List<Duree> getAll() {
        return dureeRepository.findAll();
    }

    @Override
    public Duree GetId(long id) {
        return dureeRepository.findById(id).get();
    }

    @Override
    public Duree GetByName(String name) {
        return dureeRepository.findByDuree(name);
    }
}
