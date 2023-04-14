package com.example.neko.Service_Implementation;

import com.example.neko.Models.Entreprise;
import com.example.neko.Repository.EntrepriseRepository;
import com.example.neko.Services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
    @Autowired
    EntrepriseRepository entrepriseRepository;
    public Entreprise Creer(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public Entreprise Modifier(long id, Entreprise entreprise) {
        return entrepriseRepository.findById(id)
                .map(p->{
                            p.setDomaine(entreprise.getDomaine());
                            return entrepriseRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modification a echoué"));
    }


    @Override
    public void Supprimer(long id) {
        entrepriseRepository.deleteById(id);

    }

    @Override
    public List<Entreprise> getAll() {
        return entrepriseRepository.findAll();
    }

    @Override
    public Entreprise GetId(long id) {
        return entrepriseRepository.findById(id).get();
    }

    @Override
    public Entreprise GetByDomaine(String name) {
        return entrepriseRepository.findByDomaine(name);
    }


}
