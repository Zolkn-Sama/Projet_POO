package Projet_POO.Service.implementation;

import java.util.List;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Repository.AgentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import Projet_POO.Domain.Entity.NoteAgent;
import Projet_POO.Repository.NoteAgentRepository;
import Projet_POO.Service.NoteAgentService;

@Service
public class NoteAgentServiceImpl implements NoteAgentService {

    private final NoteAgentRepository repo;
    private final AgentRepository agentRepo; 

    // Injection par constructeur (Recommandé)
    public NoteAgentServiceImpl(NoteAgentRepository repo, AgentRepository agentRepo) {
        this.repo = repo;
        this.agentRepo = agentRepo;
    }

    @Override
    public NoteAgent creer(NoteAgent note, Long agentId) {

        // 1. Rechercher l'agent en base de données
        Agent agent = agentRepo.findById(agentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent introuvable avec l'ID : " + agentId));

        // 2. Associer l'objet Agent à la Note
        note.setAgent(agent);

        // 3. Garantir une nouvelle création en forçant l'ID à null
        note.setId(null);

        // 4. Sauvegarder
        return repo.save(note);
    }

    @Override
    public List<NoteAgent> toutes() {
        return repo.findAll();
    }

    @Override
    public List<NoteAgent> parAgent(Long agentId) {
        // Recherche par ID d'agent 
        List<NoteAgent> notes = repo.findByAgentId(agentId);

        if (notes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune note trouvée pour cet agent");
        }
        return notes;
    }
}
