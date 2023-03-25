package com.example.neko.Repository;

import com.example.neko.Models.Pubphoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubphotoRepository extends JpaRepository<Pubphoto,Long> {
}
