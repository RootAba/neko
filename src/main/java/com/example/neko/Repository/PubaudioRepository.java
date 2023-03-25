package com.example.neko.Repository;

import com.example.neko.Models.Pubaudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubaudioRepository extends JpaRepository<Pubaudio,Long> {
}
