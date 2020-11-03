package com.exercise.VO;

import co.com.sofka.domain.generic.Identity;

public class Cedula extends Identity {
    public Cedula(String cedula) {
        super(cedula);
    }
    public static Cedula of(String cedula){
        return new Cedula(cedula);
    }
    public Cedula() {}
}
