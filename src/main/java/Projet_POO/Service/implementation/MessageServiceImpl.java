package Projet_POO.Service.implementation;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.Conversation;
import Projet_POO.Domain.Entity.Message;
import Projet_POO.Repository.ConversationRepository;
import Projet_POO.Repository.MessageRepository;
import Projet_POO.Service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ConversationRepository conversationRepository;

    // Regex pour mails et téléphone
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("(\\+\\d{1,3}[\\s-]?)?(\\d[\\s-]?){9,}");

    public MessageServiceImpl(MessageRepository messageRepository,
                              ConversationRepository conversationRepository) {
        this.messageRepository = messageRepository;
        this.conversationRepository = conversationRepository;
    }

    @Override
    public List<Message> findByConversationId(Long conversationId) {
        return messageRepository.findByConversationId(conversationId);
    }

    @Override
    public Message findById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Message non trouvé"
                ));
    }

    @Override
    public Message create(Long conversationId, Message message) {
        validateContenu(message.getContenu());

        Conversation conversation = conversationRepository.findById(conversationId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Conversation non trouvée"
                ));

        message.setConversation(conversation);
        return messageRepository.save(message);
    }

    @Override
    public Message update(Long id, String contenu) {
        validateContenu(contenu);

        Message existing = findById(id);
        existing.setContenu(contenu);

        return messageRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!messageRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Message non trouvé"
            );
        }
        messageRepository.deleteById(id);
    }

    private void validateContenu(String contenu) {
        if (contenu == null) return;

        if (EMAIL_PATTERN.matcher(contenu).find()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Le contenu du message ne doit pas contenir d'adresse e-mail."
            );
        }

        if (PHONE_PATTERN.matcher(contenu).find()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Le contenu du message ne doit pas contenir de numéro de téléphone."
            );
        }
    }
}
