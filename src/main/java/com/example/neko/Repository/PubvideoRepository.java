package com.example.neko.Repository;

import com.example.neko.Models.PubVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubvideoRepository extends JpaRepository<PubVideo,Long> {
    PubVideo findByPubvideo(String name);
}
