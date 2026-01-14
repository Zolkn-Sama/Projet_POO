package Projet_POO.Domain.Entity;

<<<<<<< HEAD
import jakarta.persistence.*;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
>>>>>>> ALEX

@Entity
@Table(name = "type_vehicule")
public class TypeVehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Long id;
=======
    private int id;

    private String libelle; // ex : Voiture, Bateau, Avion...
    private String domaine; // DomaineDeplacement

    // ✅ CONSTRUCTEUR VIDE OBLIGATOIRE POUR JPA/HIBERNATE
    public TypeVehicule() {
    }
>>>>>>> ALEX

    private String libelle;   // Voiture, Moto...
    private String domaine;   // DomaineDeplacement en String (ok pour le moment)

    public TypeVehicule() {}

    public TypeVehicule(String libelle, String domaine) {
        this.libelle = libelle;
        this.domaine = domaine;
    }

<<<<<<< HEAD
    public Long getId() { return id; }
=======
    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
>>>>>>> ALEX

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public String getDomaine() { return domaine; }
    public void setDomaine(String domaine) { this.domaine = domaine; }
<<<<<<< HEAD
}
=======
}
>>>>>>> ALEX
