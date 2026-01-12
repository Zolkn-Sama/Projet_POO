package Projet_POO.Domain.Entity;

import Projet_POO.Domain.Enums.CodeOption;
import jakarta.persistence.*;

@Entity
@Table(name = "option_vehicule")
public class OptionVehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CodeOption code;

    public OptionVehicule() {}

    public OptionVehicule(CodeOption code) {
        this.code = code;
    }

    public Long getId() { return id; }

    public CodeOption getCode() { return code; }
    public void setCode(CodeOption code) { this.code = code; }

    @Override
    public String toString() {
        return code.name();
    }
}
