package com.example.neko.Service_Implementation;

import com.example.neko.Models.Pubphoto;
import com.example.neko.Repository.PubphotoRepository;
import com.example.neko.Services.PubphotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PubphotoServiceImmplment implements PubphotoService {
    @Autowired
    PubphotoService pubphotoService;
    @Autowired
    PubphotoRepository pubphotoRepository;
    @Override
    public Pubphoto Creer(Pubphoto pubphoto) {
        return pubphotoRepository.save(pubphoto);
    }

    @Override
    public Pubphoto Modifier(long id, Pubphoto pubphoto) {
        return pubphotoRepository.findById(id)
                .map(p->{
                            p.setPhoto(pubphoto.getPhoto());
                            return pubphotoRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modication a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        pubphotoRepository.deleteById(id);

    }

    @Override
    public List<Pubphoto> getAll() {
        return pubphotoRepository.findAll();
    }

    @Override
    public Pubphoto GetId(long id) {
        return pubphotoRepository.findById(id).get();
    }

    @Override
    public Pubphoto GetByName(String name) {
        return pubphotoRepository.findByPubphoto(name);
    }
}
