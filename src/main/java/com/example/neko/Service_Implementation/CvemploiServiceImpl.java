package com.example.neko.Service_Implementation;

import com.example.neko.Models.Cvemploi;
import com.example.neko.Repository.CvemploiRepository;
import com.example.neko.Services.CvemploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvemploiServiceImpl implements CvemploiService {
    @Autowired
    CvemploiRepository cvemploiRepository;
    @Override
    public Cvemploi Creer(Cvemploi cvemploi) {
        return cvemploiRepository.save(cvemploi);
    }

    @Override
    public Cvemploi Modifier(long id, Cvemploi cvemploi) {
        return cvemploiRepository.findById(id)
                .map(p->{
                            p.setCv(cvemploi.getCv());
                            return cvemploiRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modification a echoué"));
    }


    @Override
    public void Supprimer(long id) {
        cvemploiRepository.deleteById(id);

    }

    @Override
    public List<Cvemploi> getAll() {
        return cvemploiRepository.findAll();
    }

    @Override
    public Cvemploi GetId(long id) {
        return cvemploiRepository.findById(id).get();
    }

    @Override
    public Cvemploi GetByName(String name) {
        return cvemploiRepository.findByCvemploi(name);
    }
}
