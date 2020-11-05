package com.exercise.pista.values;

import co.com.sofka.domain.generic.Identity;

public class CodigoPista  extends Identity {

    public CodigoPista() {}

    public CodigoPista(String codigoPista) {
        super(codigoPista);
    }

    public static CodigoPista of(String codigoPista) {
        return new CodigoPista(codigoPista);
    }
}