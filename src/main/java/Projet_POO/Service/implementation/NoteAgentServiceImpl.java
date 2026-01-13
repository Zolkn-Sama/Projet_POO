package Projet_POO.Service.implementation;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import Projet_POO.Domain.Entity.NoteAgent;
import Projet_POO.Repository.NoteAgentRepository;
import Projet_POO.Service.NoteAgentService;

@Service
public class NoteAgentServiceImpl implements NoteAgentService {

    private final NoteAgentRepository repo;

    public NoteAgentServiceImpl(NoteAgentRepository repo) {
        this.repo = repo;
    }

    @Override
    public NoteAgent creer(NoteAgent note) {
        // Garantir une nouvelle création en forçant l'ID à null
        note.setId(null);
        return repo.save(note);
    }

    @Override
    public List<NoteAgent> toutes() {
        return repo.findAll();
    }

    @Override
    public List<NoteAgent> parAgent(Long agentId) {
        // Recherche par ID d'agent avec gestion d'erreur (modèle AgentServiceImpl)
        List<NoteAgent> notes = repo.findByAgentId(agentId);
        if (notes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune note trouvée pour cet agent");
        }
        return notes;
    }
}