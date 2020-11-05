package com.exercise.pista.values;

import co.com.sofka.domain.generic.Identity;

public class NumeroCarril extends Identity {

    public NumeroCarril() {}

    public NumeroCarril(String numeroCarril) {
        super(numeroCarril);
    }

    public static NumeroCarril of(String numeroCarril) { return new NumeroCarril(numeroCarril);}

}
