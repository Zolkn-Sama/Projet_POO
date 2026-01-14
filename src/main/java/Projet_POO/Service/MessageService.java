package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.Message;

public interface MessageService {

    List<Message> findByConversationId(Long conversationId);

    Message findById(Long id);

    Message create(Long conversationId, Message message);

    Message update(Long id, String message);

    void delete(Long id);
}
