package com.example.neko.Service_Implementation;

import com.example.neko.Models.Utilisateur;
import com.example.neko.Repository.UtilisateurRepository;
import com.example.neko.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UtilisateurServiceImple implements UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Override
    public Utilisateur Creer(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur Modifier(long id, Utilisateur utilisateur) {
        return utilisateurRepository.findById(id)
                .map(p->{
                            p.setAmis(utilisateur.getAmis());
                            return utilisateurRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modication a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        utilisateurRepository.deleteById(id);

    }

    @Override
    public List<Utilisateur> getAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur GetId(long id) {
        return utilisateurRepository.findById(id).get();
    }

    @Override
    public Utilisateur GetByName(String name) {
        return utilisateurRepository.findByUtilisateur(name);
    }
}
