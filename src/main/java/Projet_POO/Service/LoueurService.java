package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.Loueur;

public interface LoueurService {
    List<Loueur> findAll();
    Loueur findByUtilisateurId(Long id);
    Loueur findByUtilisateurEmail(String email);
    Loueur create(Loueur loueur);
    Loueur create(long id);
    Loueur update(Long id, Loueur loueur);
    void delete(Long id);
}
