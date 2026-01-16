package Projet_POO.Service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Domain.Entity.Conversation;
import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Repository.ConversationRepository;
import Projet_POO.Service.ConversationService;

@Service
public class ConversationServiceImpl implements ConversationService {

    private final ConversationRepository conversationRepository;

    public ConversationServiceImpl(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    @Override
    public List<Conversation> findAll() {
        return conversationRepository.findAll();
    }

    @Override
    public Conversation findById(Long id) {
        return conversationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Conversation non trouvée"
                ));
    }

    @Override
    public List<Conversation> findByLoueur(Loueur loueur) {
        return conversationRepository.findByLoueur(loueur);
    }

    @Override
    public List<Conversation> findByAgent(Agent agent) {
        return conversationRepository.findByAgent(agent);
    }

    @Override
    public Conversation findOrCreateBetween(Agent agent, Loueur loueur) {
        return conversationRepository
                .findByAgentIdAndLoueurId(agent.getId(), loueur.getId())
                .orElseGet(() -> {
                    Conversation c = new Conversation();
                    c.setAgent(agent);
                    c.setLoueur(loueur);
                    return conversationRepository.save(c);
                });
    }


    @Override
    public Conversation create(Conversation conversation) {
        conversation.setId(null);
        return conversationRepository.save(conversation);
    }

    @Override
    public Conversation update(Long id, String name) {
        Conversation existing = findById(id);
        existing.setNom(name);
        return conversationRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!conversationRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Conversation non trouvée"
            );
        }
        conversationRepository.deleteById(id);
    }
}
