package com.example.neko.Service_Implementation;

import com.example.neko.Models.PubVideo;
import com.example.neko.Repository.PubvideoRepository;
import com.example.neko.Services.PubvideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PubvideoServiceImplemnt implements PubvideoService {

    @Autowired
    PubvideoRepository pubvideoRepository;
    @Override
    public PubVideo Creer(PubVideo pubVideo) {
        return pubvideoRepository.save(pubVideo);
    }

    @Override
    public PubVideo Modifier(long id, PubVideo pubVideo) {
        return pubvideoRepository.findById(id)
                .map(p->{
                            p.setVideo(pubVideo.getVideo());
                            return pubvideoRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Modication a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        pubvideoRepository.deleteById(id);

    }

    @Override
    public List<PubVideo> getAll() {
        return pubvideoRepository.findAll();
    }

    @Override
    public PubVideo GetId(long id) {
        return pubvideoRepository.findById(id).get();
    }

  /*  @Override
    public PubVideo GetByName(String name) {
        return pubvideoRepository.findByPubvideo(name);
    }*/
}
