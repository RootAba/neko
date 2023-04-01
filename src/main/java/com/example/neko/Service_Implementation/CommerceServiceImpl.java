package com.example.neko.Service_Implementation;

import com.example.neko.Models.Commerce;
import com.example.neko.Repository.CommerceRepository;
import com.example.neko.Services.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommerceServiceImpl implements CommerceService {
    @Autowired
    CommerceRepository commerceRepository;
    @Override
    public Commerce Creer(Commerce commerce) {
        return commerceRepository.save(commerce);
    }

    @Override
    public Commerce Modifier(long id, Commerce commerce) {
        return commerceRepository.findById(id)
                .map(p->{
                            p.setNom(commerce.getNom());
                            return commerceRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modification a echoué"));
    }
    }

    @Override
    public void Supprimer(long id) {
        commerceRepository.deleteById(id);

    }

    @Override
    public List<Commerce> getAll() {
        return commerceRepository.findAll();
    }

    @Override
    public Commerce GetId(long id) {
        return commerceRepository.findById(id).get();
    }

    @Override
    public Commerce GetByName(String name) {
        return commerceRepository.findByCommerce(name);
    }
}
