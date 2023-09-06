package com.example.neko.Service_Implementation;

import com.example.neko.Models.Commentaires;
import com.example.neko.Models.Publications;
import com.example.neko.Repository.CommentaireRepository;
import com.example.neko.Services.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentServiceImplemt implements CommentaireService {
    @Autowired
    CommentaireRepository commentaireRepository;
    @Override
    public Commentaires Creer(Commentaires commentaires) {
        return commentaireRepository.save(commentaires);
    }

    @Override
    public Commentaires Modifier(long id, Commentaires commentaires) {
        return commentaireRepository.findById(id)
                .map(p->{
                            p.setContenu(commentaires.getContenu());
                            return commentaireRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modification a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        commentaireRepository.deleteById(id);

    }

    @Override
    public List<Commentaires> getAll() {
        return commentaireRepository.findAll();
    }

    @Override
    public Commentaires GetId(long id) {
        return commentaireRepository.findById(id).get();
    }

    @Override
    public List<Commentaires> getAllByIdPub(Publications publications) {
      /*  List<Commentaires> Comm =    commentaireRepository.findByPublicationsId(id);
        List<Commentaires> commDTOs = new ArrayList<>();

        for (Commentaires commEntity : Comm) {
           // Commentaires commDTO = new Commentaires();
            // Set other properties in the DTO as needed
            commDTOs.add(commEntity);
        }*/

        return commentaireRepository.findByPublications(publications);
    }

  /*  @Override
    public Commentaires GetByName(String name) {
        return commentaireRepository.findByCommentaire(name);
    }*/
}
