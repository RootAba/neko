package com.example.neko.Service_Implementation;

import com.example.neko.Models.Annonces;
import com.example.neko.Repository.AnnonceRepository;
import com.example.neko.Services.AnnoncesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnoncesServicesImpl implements AnnoncesService {
    @Autowired
    AnnonceRepository annonceRepository;
    @Override
    public Annonces Creer(Annonces annonces) {

        return annonceRepository.save(annonces);
    }

    @Override
    public Annonces Modifier(long id, Annonces annonces) {
        return annonceRepository.findById(id)
                .map(p->{
            p.setAnnonce(annonces.getAnnonce());
            return annonceRepository.save(p);
        }
        ).orElseThrow(()->new RuntimeException("Modication a echoué"));
    }

    @Override
    public void Supprimer(long id) {
         annonceRepository.deleteById(id);
    }

    @Override
    public List<Annonces> getAll() {
        return annonceRepository.findAll();
    }

    @Override
    public Annonces GetId(long id) {
        return annonceRepository.findById(id).get();
    }

    @Override
    public Annonces GetByName(String name) {
        return annonceRepository.findByAnnonce(name);
    }
}
