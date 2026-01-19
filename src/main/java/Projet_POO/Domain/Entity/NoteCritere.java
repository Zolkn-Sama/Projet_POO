package Projet_POO.Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "note_critere")
public class NoteCritere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private int valeur; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "note_id")
    @JsonIgnore
    private Note note;

    public NoteCritere() {}

    public NoteCritere(String nom, int valeur) {
        this.nom = nom;
        this.valeur = valeur;
    }

    public Long getId() { return id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getValeur() { return valeur; }
    public void setValeur(int valeur) { this.valeur = valeur; }

    public Note getNote() { return note; }
    public void setNote(Note note) { this.note = note; }
}

