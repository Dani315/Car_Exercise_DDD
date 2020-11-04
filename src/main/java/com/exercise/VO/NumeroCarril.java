package com.exercise.VO;

import co.com.sofka.domain.generic.Identity;

public class NumeroCarril extends Identity {

    public NumeroCarril(String value) {
        super(value);
    }

    public static NumeroCarril of(String value) {
        return new NumeroCarril(value);
    }

    public NumeroCarril() {
    }
}
