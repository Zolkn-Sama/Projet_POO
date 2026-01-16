package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Domain.Entity.Conversation;
import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Service.ConversationService;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {

    private final ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping
    public List<Conversation> getAll() {
        return conversationService.findAll();
    }

    @GetMapping("/ById/{id}")
    public Conversation getById(@PathVariable Long id) {
        return conversationService.findById(id);
    }

    @GetMapping("/ByLoueur/{loueur}")
    public List<Conversation> getByLoueur(@PathVariable Loueur loueur) {
        return conversationService.findByLoueur(loueur);
    }

    @GetMapping("/ByAgent/{agent}")
    public List<Conversation> getByAgent(@PathVariable Agent agent) {
        return conversationService.findByAgent(agent);
    }

    @PostMapping
    public Conversation create(@RequestBody Conversation conversation) {
        return conversationService.create(conversation);
    }

    @PutMapping("/{id}")
    public Conversation update(@PathVariable Long id,
                               @RequestBody String name) {
        return conversationService.update(id, name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        conversationService.delete(id);
    }

}
