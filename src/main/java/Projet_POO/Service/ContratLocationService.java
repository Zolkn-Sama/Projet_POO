package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.ContratLocation;

public interface ContratLocationService {

    List<ContratLocation> findAll();

    ContratLocation findById(Long id);

    List<ContratLocation> findByLoueur(Long loueurId);

    List<ContratLocation> findByVehicule(Long vehiculeId);

    ContratLocation create(ContratLocation contrat);

    ContratLocation update(Long id, ContratLocation contrat);

    void delete(Long id);
}
