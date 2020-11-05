package com.exercise.pista.values;

import co.com.sofka.domain.generic.Identity;

public class Placa extends Identity {
    public Placa() {}

    public Placa(String placa) {
        super(placa);
    }

    public static  Placa of(String placa) {
        return new Placa(placa);
    }
}
