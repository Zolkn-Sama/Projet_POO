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
     * Enregistre une nouvelle évaluation pour un Agent spécifique.
     * URL : POST /api/notes-agent/{agentId}
     */
    // 🟢 CHANGEMENT : On récupère l'ID de l'agent via l'URL
    @PostMapping("/{agentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public NoteAgent create(@PathVariable Long agentId, @RequestBody NoteAgent note) {
        // On passe l'ID et l'objet Note au service
        return noteAgentService.creer(note, agentId);
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
     * URL : GET /api/notes-agent/agent/{agentId}
     */
    @GetMapping("/agent/{agentId}")
    public List<NoteAgent> getByAgent(@PathVariable Long agentId) {
        return noteAgentService.parAgent(agentId);
    }
}