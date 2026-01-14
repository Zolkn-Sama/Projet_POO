package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.Conversation;

public interface ConversationService {

    List<Conversation> findAll();

    Conversation findById(Long id);

    Conversation create(Conversation conversation);

    Conversation update(Long id, String name);

    void delete(Long id);
}
