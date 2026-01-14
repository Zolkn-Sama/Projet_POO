package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Projet_POO.Domain.Entity.Message;
import Projet_POO.Service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // GET /api/messages?conversationId=...
    @GetMapping
    public List<Message> getByConversation(@RequestParam Long conversationId) {
        return messageService.findByConversationId(conversationId);
    }

    @GetMapping("/{id}")
    public Message getById(@PathVariable Long id) {
        return messageService.findById(id);
    }

    // POST /api/messages?conversationId=...
    @PostMapping
    public Message create(@RequestParam Long conversationId,
                          @RequestBody Message message) {
        return messageService.create(conversationId, message);
    }

    @PutMapping("/{id}")
    public Message update(@PathVariable Long id,
                          @RequestBody String contenu) {
        return messageService.update(id, contenu);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        messageService.delete(id);
    }
}
