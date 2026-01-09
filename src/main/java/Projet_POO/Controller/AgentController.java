package Projet_POO.Controller;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Service.AgentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController {

    private final AgentService service;

    public AgentController(AgentService service) {
        this.service = service;
    }

    @PostMapping
    public Agent creer(@RequestBody Agent agent) {
        return service.creer(agent);
    }

    @GetMapping
    public List<Agent> tous() {
        return service.tous();
    }
}
