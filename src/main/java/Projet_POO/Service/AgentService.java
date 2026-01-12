package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.Agent;

public interface AgentService {

    List<Agent> findAll();

    Agent findById(Long id);

    Agent findByEmail(String email);

    Agent create(Agent agent);

    Agent update(Long id, Agent agent);

    void delete(Long id);
}

