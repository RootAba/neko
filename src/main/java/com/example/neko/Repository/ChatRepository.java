package com.example.neko.Repository;

import com.example.neko.Models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Long> {
    Chat findByChat(String name);
}
