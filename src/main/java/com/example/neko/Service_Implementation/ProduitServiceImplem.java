package com.example.neko.Service_Implementation;

import com.example.neko.Models.Produits;
import com.example.neko.Repository.ProduitRepository;
import com.example.neko.Services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitServiceImplem implements ProduitService {
    @Autowired
    ProduitRepository produitRepository;
    @Override
    public Produits Creer(Produits produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produits Modifier(int id, Produits produit) {
        return produitRepository.findById(id)
                .map(p->{
                            p.setPrix(produit.getPrix());
                            return produitRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modication a echoué"));
    }

    @Override
    public void Supprimer(int id) {
        produitRepository.deleteById(id);

    }

    @Override
    public List<Produits> getAll() {
        return produitRepository.findAll();
    }

    @Override
    public Produits GetId(int id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public Produits GetByName(String name) {
        return produitRepository.findByNom(name);
    }
}
