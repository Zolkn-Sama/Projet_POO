package Projet_POO.Controller;

import Projet_POO.Domain.Entity.ConditionsAgent;
import Projet_POO.Service.ConditionsAgentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conditions-agents")
public class ConditionsAgentController {

    private final ConditionsAgentService service;

    public ConditionsAgentController(ConditionsAgentService service) {
        this.service = service;
    }

    @GetMapping
    public List<ConditionsAgent> getAll() {
        return service.listerToutes();
    }

    @PostMapping
    public ConditionsAgent creer(@RequestBody ConditionsAgent condition) {
        return service.sauvegarder(condition);
    }
}