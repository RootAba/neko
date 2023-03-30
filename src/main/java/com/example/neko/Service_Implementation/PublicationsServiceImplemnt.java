package com.example.neko.Service_Implementation;

import com.example.neko.Models.Publications;
import com.example.neko.Repository.PublicationRepository;
import com.example.neko.Services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PublicationsServiceImplemnt implements PublicationService {
    @Autowired
    PublicationService publicationService;
    @Autowired
    PublicationRepository publicationRepository;
    @Override
    public Publications Creer(Publications publications) {
        return publicationRepository.save(publications);
    }

    @Override
    public Publications Modifier(long id, Publications publications) {
        return null;
    }

    @Override
    public void Supprimer(long id) {
        publicationRepository.deleteById(id);

    }

    @Override
    public List<Publications> getAll() {
        return publicationRepository.findAll();
    }

    @Override
    public Publications GetId(long id) {
        return publicationRepository.findById(id).get();
    }

    @Override
    public Publications GetByName(String name) {
        return publicationRepository.findByPublication(name);
    }
}
