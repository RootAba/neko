package com.example.neko.Service_Implementation;

import com.example.neko.Models.Domaineactivite;
import com.example.neko.Repository.DomaineactiviteRepository;
import com.example.neko.Services.DomaineactiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DomaineActiviteServiceImpl implements DomaineactiviteService {
    @Autowired
    DomaineactiviteRepository domaineactiviteRepository;
    @Override
    public Domaineactivite Creer(Domaineactivite domaineactivite) {
        return domaineactiviteRepository.save(domaineactivite);
    }

    @Override
    public Domaineactivite Modifier(long id, Domaineactivite domaineactivite) {
        return domaineactiviteRepository.findById(id)
                .map(p->{
                            p.setDomaine(domaineactivite.getDomaine());
                            return domaineactiviteRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modication a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        domaineactiviteRepository.deleteById(id);

    }

    @Override
    public List<Domaineactivite> getAll() {
        return domaineactiviteRepository.findAll();
    }

    @Override
    public Domaineactivite GetId(long id) {
        return domaineactiviteRepository.findById(id).get();
    }

    @Override
    public Domaineactivite GetByName(String name) {
        return domaineactiviteRepository.findByDomaine(name);
    }
}
