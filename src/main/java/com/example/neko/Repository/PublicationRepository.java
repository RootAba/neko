package com.example.neko.Repository;

import com.example.neko.Models.Publications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publications,Long> {
    Publications findByPublication(String name);
}
