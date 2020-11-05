package com.exercise.pista.values;

import co.com.sofka.domain.generic.Identity;

public class Cedula extends Identity {

    public Cedula() {}

    public Cedula(String cedula) {
        super(cedula);
    }

    public static  Cedula of(String cedula) {
        return new Cedula(cedula);
    }
}
