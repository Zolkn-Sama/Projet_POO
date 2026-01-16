package Projet_POO.Service;

import java.util.List;

import Projet_POO.Domain.Entity.Utilisateur;

public interface UtilisateurService {

    Utilisateur findById(Long id);

    Utilisateur findByEmail(String email);

    List<Utilisateur> findAll();

    Utilisateur create(Utilisateur utilisateur);

    Utilisateur update(Long id, Utilisateur utilisateur);

    void delete(Long id);

}
