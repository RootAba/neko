package com.example.neko.Service_Implementation;

import com.example.neko.Models.Invitations;
import com.example.neko.Repository.InvitationRepository;
import com.example.neko.Services.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvitationServiceImplemnt implements InvitationService {
    @Autowired
    InvitationRepository invitationRepository;
    @Override
    public Invitations Creer(Invitations invitation) {
        return invitationRepository.save(invitation);
    }

    @Override
    public Invitations Modifier(long id, Invitations invitation) {
        return invitationRepository.findById(id)
                .map(p->{
                            p.setInivitation(invitation.getInivitation());
                            return invitationRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modication a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        invitationRepository.deleteById(id);

    }

    @Override
    public List<Invitations> getAll() {
        return invitationRepository.findAll();
    }

    @Override
    public Invitations GetId(long id) {
        return invitationRepository.findById(id).get();
    }

  /*  @Override
    public Invitations GetByName(String name) {
        return invitationRepository.findByInvitation(name);
    }*/
}
