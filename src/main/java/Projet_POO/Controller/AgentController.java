package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projet_POO.Domain.Entity.Agent;
import Projet_POO.Service.AgentService;

@RestController
@RequestMapping("/agents")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping
    public List<Agent> getAll() {
        return agentService.findAll();
    }

    @GetMapping("/{id}")
    public Agent getById(@PathVariable Long id) {
        return agentService.findById(id);
    }

     @GetMapping("/{email}")
    public Agent getByEmail(@PathVariable String email) {
        return agentService.findByEmail(email);
    }

    @PostMapping
    public Agent create(@RequestBody Agent agent) {
        return agentService.create(agent);
    }

    @PutMapping("/{id}")
    public Agent update(@PathVariable Long id, @RequestBody Agent agent) {
        return agentService.update(id, agent);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        agentService.delete(id);
    }
}
