package com.example.neko.Service_Implementation;

import com.example.neko.Models.Typeactivite;
import com.example.neko.Repository.TypeactiviteRepository;
import com.example.neko.Services.TypeactiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeactiviteServiceImpl implements TypeactiviteService {
    @Autowired
    TypeactiviteRepository typeactiviteRepository;
    @Override
    public Typeactivite Creer(Typeactivite typeactivite) {
        return typeactiviteRepository.save(typeactivite);
    }

    @Override
    public Typeactivite Modifier(long id, Typeactivite typeactivite) {
        return typeactiviteRepository.findById(id)
                .map(p->{
                            p.setType(typeactivite.getType());
                            return typeactiviteRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modication a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        typeactiviteRepository.deleteById(id);

    }

    @Override
    public List<Typeactivite> getAll() {
        return typeactiviteRepository.findAll();
    }

    @Override
    public Typeactivite GetId(long id) {
        return typeactiviteRepository.findById(id).get();
    }

    @Override
    public Typeactivite GetByName(String name) {
        return typeactiviteRepository.findByType(name);
    }
}
