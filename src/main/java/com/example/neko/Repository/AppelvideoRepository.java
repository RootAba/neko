package com.example.neko.Repository;

import com.example.neko.Models.Appelvideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppelvideoRepository extends JpaRepository<Appelvideo,Long> {
    Appelvideo findByAppelVideo(String name);
}
