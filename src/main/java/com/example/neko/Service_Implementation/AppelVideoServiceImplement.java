package com.example.neko.Service_Implementation;

import com.example.neko.Models.Appelvideo;
import com.example.neko.Repository.AppelvideoRepository;
import com.example.neko.Services.AppelvideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppelVideoServiceImplement implements AppelvideoService {
    @Autowired
    AppelvideoRepository appelvideoRepository;
    @Override
    public Appelvideo Creer(Appelvideo appelvideo) {
        return appelvideoRepository.save(appelvideo);
    }

    @Override
    public Appelvideo Modifier(long id, Appelvideo appelvideo) {
        return null;
    }


    @Override

    public void Supprimer(long id) {
        appelvideoRepository.deleteById(id);
    }

    @Override
    public List<Appelvideo> getAll() {
        return appelvideoRepository.findAll();
    }

    @Override
    public Appelvideo GetId(long id) {
        return appelvideoRepository.findById(id).get();
    }

    @Override
    public Appelvideo GetByName(String name) {
        return appelvideoRepository.findByAppelVideo(name);
    }
}
