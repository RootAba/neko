package com.example.neko.Service_Implementation;

import com.example.neko.Models.Emploi;
import com.example.neko.Repository.EmploiRepository;
import com.example.neko.Services.EmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmploiServiceImple implements EmploiService {
    @Autowired
    EmploiRepository emploiRepository;
    @Override
    public Emploi Creer(Emploi emploi) {
        return emploiRepository.save(emploi);
    }

    @Override
    public Emploi Modifier(long id, Emploi emploi) {
        return null;
    }

    @Override
    public void Supprimer(long id) {
        emploiRepository.deleteById(id);

    }

    @Override
    public List<Emploi> getAll() {
        return emploiRepository.findAll();
    }

    @Override
    public Emploi GetId(long id) {
        return emploiRepository.findById(id).get();
    }

    @Override
    public Emploi GetByName(String name) {
        return emploiRepository.findByEmploi(name);
    }
}
