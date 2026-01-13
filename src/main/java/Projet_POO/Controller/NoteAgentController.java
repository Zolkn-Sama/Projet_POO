package Projet_POO.Controller;

import Projet_POO.Domain.Entity.NoteAgent;
import Projet_POO.Service.NoteAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes-agent")
public class NoteAgentController {

    @Autowired
    private NoteAgentService noteAgentService;

    /**
     * Crée une nouvelle évaluation pour un agent.
     * Le service se charge de forcer l'ID à null pour l'insertion.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoteAgent create(@RequestBody NoteAgent note) {
        return noteAgentService.creer(note);
    }

    /**
     * Récupère toutes les notes d'agents existantes.
     */
    @GetMapping
    public List<NoteAgent> getAll() {
        return noteAgentService.toutes();
    }

    /**
     * Récupère les notes d'un agent spécifique.
     * Si aucune note n'est trouvée, le service lance une ResponseStatusException (404).
     */
    @GetMapping("/agent/{agentId}")
    public List<NoteAgent> getByAgent(@PathVariable Long agentId) {
        return noteAgentService.parAgent(agentId);
    }
}