package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.Loueur;

public interface LoueurService {
    List<Loueur> findAll();
    Loueur findById(Long id);
    Loueur findByEmail(String email);
    Loueur create(Loueur loueur);
    Loueur update(Long id, Loueur loueur);
    void delete(Long id);
}
