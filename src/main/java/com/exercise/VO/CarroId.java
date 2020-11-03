package com.exercise.VO;

import co.com.sofka.domain.generic.Identity;

public class CarroId extends Identity {

    public CarroId(String placa) {
        super(placa);
    }

    public static CarroId of(String placa) {
        return new CarroId(placa);
    }

    public CarroId() {}
}
