package com.example.neko.Service_Implementation;

import com.example.neko.Models.Pubaudio;
import com.example.neko.Repository.PubaudioRepository;
import com.example.neko.Services.PubaudioService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PubAudioServiceImplemnt implements PubaudioService {
    PubaudioRepository pubaudioRepository;
    @Override
    public Pubaudio Creer(Pubaudio pubaudio) {
        return pubaudioRepository.save(pubaudio);
    }

    @Override
    public Pubaudio Modifier(long id, Pubaudio pubaudio) {
        return pubaudioRepository.findById(id)
                .map(p->{
                            p.setAudio(pubaudio.getAudio());
                            return pubaudioRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modication a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        pubaudioRepository.deleteById(id);

    }

    @Override
    public List<Pubaudio> getAll() {
        return pubaudioRepository.findAll();
    }

    @Override
    public Pubaudio GetId(long id) {
        return pubaudioRepository.findById(id).get();
    }

    @Override
    public Pubaudio GetByName(String name) {
        return pubaudioRepository.findByPubAudio(name);
    }
}
