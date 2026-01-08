package Projet_POO.Domain.Entity;

import Projet_POO.Domain.Enums.CodeOption;

public class OptionVehicule {

    private CodeOption code;

    public OptionVehicule(CodeOption code) {
        this.code = code;
    }

    public CodeOption getCode() {
        return code;
    }

    public void setCode(CodeOption code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code.name();
    }
}
