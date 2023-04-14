package com.example.neko.Service_Implementation;

import com.example.neko.Models.Chat;
import com.example.neko.Repository.ChatRepository;
import com.example.neko.Services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChatServiceImplemt implements ChatService {
    @Autowired
    ChatRepository chatRepository;
    @Override
    public Chat Creer(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public Chat Modifier(long id, Chat chat) {
        return chatRepository.findById(id)
                .map(p->{
                            p.setContenu(chat.getContenu());
                            return chatRepository.save(p);
                        }
                ).orElseThrow(()->new RuntimeException("Chat a echoué"));
    }

    @Override
    public void Supprimer(long id) {
        chatRepository.deleteById(id);

    }

    @Override
    public List<Chat> getAll() {
        return chatRepository.findAll();
    }

    @Override
    public Chat GetId(long id) {
        return chatRepository.findById(id).get();
    }

   /* @Override
    public Chat GetByName(String name) {
        return chatRepository.fin(name);
    }*/
}
