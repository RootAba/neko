package com.example.neko.Service_Implementation;

import com.example.neko.Models.PubStory;
import com.example.neko.Services.PubStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.neko.Repository.PubStoryRepository;
@Service
public class PubStoryServiceImplement implements PubStoryService {
    @Autowired
    PubStoryRepository pubStoryRepository;
    @Override
    public PubStory Creer(PubStory pubStory) {
        return pubStoryRepository.save(pubStory);
    }

    @Override
    public PubStory Modifier(long id, PubStory pubstory) {
        return pubStoryRepository.findById(id)
                .map(p->{
                            p.setStory(pubstory.getStory());
                            return pubStoryRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modication a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        pubStoryRepository.deleteById(id);
    }

    @Override
    public List<PubStory> getAll() {
        return pubStoryRepository.findAll();
    }

    @Override
    public PubStory GetId(long id) {
        return pubStoryRepository.findById(id).get();
    }
}
