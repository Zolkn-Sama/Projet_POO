package Projet_POO.Domain.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String password;

    @Column(unique = true, nullable = false)
    private String email;
    private String telephone;
    private Localisation localisationUtilisateur;
    private LocalDate dateNaissance;
    private String numeroPermis;
    private LocalDate dateObtentionPermis;
    private double solde;

    private String role;

    @OneToOne(mappedBy = "utilisateur", fetch = FetchType.LAZY)
    @JsonIgnore
    private Agent agent;

    @OneToOne(mappedBy = "utilisateur", fetch = FetchType.LAZY)
    @JsonIgnore
    private Loueur loueur;

    // --------- CONSTRUCTEURS ---------

    public Utilisateur() {}

    public Utilisateur(Long id,
                       String nom,
                       String prenom,
                       String password,
                       String email,
                       String telephone,
                       Localisation localisationUtilisateur,
                       LocalDate dateNaissance,
                       String numeroPermis,
                       LocalDate dateObtentionPermis,
                       double solde,
                       String role
                       ) {

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.localisationUtilisateur = localisationUtilisateur;
        this.dateNaissance = dateNaissance;
        this.numeroPermis = numeroPermis;
        this.dateObtentionPermis = dateObtentionPermis;
        this.solde = solde;
        this.role = role;
    }

    // --------- GETTERS / SETTERS ---------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNumeroPermis() { return numeroPermis; }
    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }

    public LocalDate getDateObtentionPermis() {
        return dateObtentionPermis;
    }

    public void setDateObtentionPermis(LocalDate dateObtentionPermis) {
        this.dateObtentionPermis = dateObtentionPermis;
    }
    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }

    public Localisation getLocalisationUtilisateur() {
        return localisationUtilisateur;
    }

    public void setLocalisationUtilisateur(Localisation localisationUtilisateur) {
        this.localisationUtilisateur = localisationUtilisateur;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    
    public Loueur getLoueur() {
        return loueur;
    }

    public void setLoueur(Loueur loueur) {
        this.loueur = loueur;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
