package com.example.neko.Service_Implementation;

import com.example.neko.Models.Artiste;
import com.example.neko.Repository.ArtisteRepository;
import com.example.neko.Services.ArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtisteServiceImplementation implements ArtisteService {
    @Autowired
    ArtisteRepository artisteRepository;
    @Override
    public Artiste Creer(Artiste artiste) {
        return artisteRepository.save(artiste);
    }

    @Override
    public Artiste Modifier(long id, Artiste artiste) {
        return artisteRepository.findById(id)
                .map(p->{
                            p.setEmail(artiste.getEmail());
                            return artisteRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Artiste a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        artisteRepository.deleteById(id);

    }

    @Override
    public List<Artiste> getAll() {
        return artisteRepository.findAll();
    }

    @Override
    public Artiste GetId(long id) {
        return artisteRepository.findById(id).get();
    }

    @Override
    public Artiste GetByName(String name) {
        return artisteRepository.findByEmail(name);
    }
}
