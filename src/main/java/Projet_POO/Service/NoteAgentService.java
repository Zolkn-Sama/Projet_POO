package Projet_POO.Service;

import Projet_POO.Domain.Entity.NoteAgent;
import java.util.List;

public interface NoteAgentService {
    // 🟢 Mise à jour de la signature : ajout de l'ID de l'agent
    NoteAgent creer(NoteAgent note, Long agentId);

    List<NoteAgent> toutes();
    List<NoteAgent> parAgent(Long agentId);
}