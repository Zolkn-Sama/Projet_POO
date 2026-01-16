package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.Agent;

public interface AgentService {

    List<Agent> findAll();

    Agent findByUtilisateurId(Long id);

    Agent findByUtilisateurEmail(String email);

    Agent create(Agent agent);

    Agent create(long id);

    Agent update(Long id, Agent agent);

    void delete(Long id);
}

