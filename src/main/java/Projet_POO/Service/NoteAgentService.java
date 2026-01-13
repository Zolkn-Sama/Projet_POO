package Projet_POO.Service;

import Projet_POO.Domain.Entity.NoteAgent;
import java.util.List;

public interface NoteAgentService {
    // Créer une nouvelle note pour un agent
    NoteAgent creer(NoteAgent note);

    // Récupérer la liste de toutes les notes des agents
    List<NoteAgent> toutes();

    // Filtrer les notes par l'identifiant de l'agent
    List<NoteAgent> parAgent(Long agentId);
}