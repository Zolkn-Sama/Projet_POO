package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.Assurance;

public interface AssuranceService {

    List<Assurance> findAll();

    Assurance findById(Long id);

    Assurance findByNom(String nom);

    Assurance create(Assurance assurance);

    Assurance update(Long id, Assurance assurance);

    void delete(Long id);
}
