package com.example.neko.Controllers;


import com.example.neko.Models.Chat;
import com.example.neko.Repository.ChatRepository;
import com.example.neko.Services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/chat")

public class ChatController {
    @Autowired
    ChatService chatService;
    @Autowired
    ChatRepository chatRepository;

    @PostMapping("/creer")
    public Chat Creer(@RequestBody Chat chat) {
        return chatService.Creer(chat);
    }

    @PutMapping("/modifier/{id}")
    public Chat Modifier(@PathVariable("id") long id, @RequestBody Chat chat) {
        return chatService.Modifier(id, chat);
    }

    @DeleteMapping("/supprimer/{id}")
    void Supprimer(@PathVariable("id") long id) {
        chatService.Supprimer(id);
    }

    @GetMapping("/get/{id}")
    public Chat getId(@PathVariable("id") long id) {
        return chatService.GetId(id);
    }

    @GetMapping("/list")
    public List<Chat> getAll() {
        return chatService.getAll();
    }
}
