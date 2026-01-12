package Projet_POO.Controller;

import Projet_POO.Domain.Entity.NoteAgent;
import Projet_POO.Service.NoteAgentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes-agents")
public class NoteAgentController {

    private final NoteAgentService service;

    public NoteAgentController(NoteAgentService service) {
        this.service = service;
    }

    @PostMapping
    public NoteAgent creer(@RequestBody NoteAgent note) {
        return service.creer(note);
    }

    @GetMapping
    public List<NoteAgent> toutes() {
        return service.toutes();
    }

    @GetMapping("/agent/{agentId}")
    public List<NoteAgent> parAgent(@PathVariable Long agentId) {
        return service.parAgent(agentId);
    }
}
