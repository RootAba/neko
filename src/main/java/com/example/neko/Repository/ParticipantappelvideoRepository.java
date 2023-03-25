package com.example.neko.Repository;

import com.example.neko.Models.Participantappelvideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantappelvideoRepository extends JpaRepository<Participantappelvideo,Long> {
}
