package com.example.neko.Repository;

import com.example.neko.Models.PubStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubStoryRepository extends JpaRepository<PubStory,Long> {
}
