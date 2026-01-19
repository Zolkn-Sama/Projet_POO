package Projet_POO.Service;

import Projet_POO.Domain.Entity.NoteAgent;
import java.util.List;

public interface NoteAgentService {
    NoteAgent creer(NoteAgent note, Long agentId);

    List<NoteAgent> toutes();
    List<NoteAgent> parAgent(Long agentId);
}
