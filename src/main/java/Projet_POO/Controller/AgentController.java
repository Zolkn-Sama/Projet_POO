package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/ById/{id}")
    public Agent findByUtilisateurId(@PathVariable Long id) {
        return agentService.findByUtilisateurId(id);
    }

    @GetMapping("/ByEmail/{email}")
    public Agent findByUtilisateurEmail(@PathVariable String email) {
        return agentService.findByUtilisateurEmail(email);
    }

    @PostMapping("/ByUtilisateur/{agent}")
    public Agent create(@RequestBody Agent agent) {
        return agentService.create(agent);
    }

    @PostMapping("/ById")
    public Agent create(@RequestParam long id) {
        return agentService.create(id);
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
