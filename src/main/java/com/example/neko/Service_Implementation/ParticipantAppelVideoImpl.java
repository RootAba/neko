package com.example.neko.Service_Implementation;

import com.example.neko.Models.Participantappelvideo;
import com.example.neko.Repository.ParticipantappelvideoRepository;
import com.example.neko.Services.ParticipantappelvideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParticipantAppelVideoImpl implements ParticipantappelvideoService {
    @Autowired
    ParticipantappelvideoRepository participantappelvideoRepository;
    @Override
    public Participantappelvideo Creer(Participantappelvideo participantappelvideo) {
        return participantappelvideoRepository.save(participantappelvideo);
    }

    @Override
    public Participantappelvideo Modifier(long id, Participantappelvideo participantappelvideo) {
        return participantappelvideoRepository.findById(id)
                .map(p->{
                            p.setAppelvideo(participantappelvideo.getAppelvideo());
                            return participantappelvideoRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modication a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        participantappelvideoRepository.deleteById(id);

    }

    @Override
    public List<Participantappelvideo> getAll() {
        return participantappelvideoRepository.findAll();
    }

    @Override
    public Participantappelvideo GetId(long id) {
        return participantappelvideoRepository.findById(id).get();
    }

  /*  @Override
    public Participantappelvideo GetByName(String name) {
        return participantappelvideoRepository.findByParticipantappelRepository(name);
    }*/
}
