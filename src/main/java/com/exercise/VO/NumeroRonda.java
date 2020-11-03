package com.exercise.VO;

import co.com.sofka.domain.generic.Identity;

public class NumeroRonda  extends Identity {
    public NumeroRonda(String value) {
        super(value);
    }

    public NumeroRonda() {}

    public static NumeroRonda of(String value) {
        return new NumeroRonda(value);
    }

}
