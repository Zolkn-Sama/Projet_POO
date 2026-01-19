package Projet_POO.Domain.Entity;

import Projet_POO.Domain.Enums.TypePropulsion;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "systeme_propulsion")
public class SystemePropulsion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypePropulsion type;

    private String energie;

    public SystemePropulsion() {} 

    public SystemePropulsion(TypePropulsion type, String energie) {

        this.type = type;
        this.energie = energie;
    }

    // Getters / Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public TypePropulsion getType() { return type; }
    public void setType(TypePropulsion type) { this.type = type; }
    public String getEnergie() { return energie; }
    public void setEnergie(String energie) { this.energie = energie; }

    public boolean estMotorise() {
        return type == TypePropulsion.MOTEUR;
    }

}
