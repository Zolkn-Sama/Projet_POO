package Projet_POO.Service;

import Projet_POO.Domain.Entity.NoteAgent;
import Projet_POO.Repository.NoteAgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteAgentService {

    private final NoteAgentRepository repo;

    public NoteAgentService(NoteAgentRepository repo) {
        this.repo = repo;
    }

    public NoteAgent creer(NoteAgent note) {
        return repo.save(note);
    }

    public List<NoteAgent> toutes() {
        return repo.findAll();
    }

    public List<NoteAgent> parAgent(Long agentId) {
        return repo.findByAgentId(agentId);
    }
}
