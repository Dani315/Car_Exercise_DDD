package com.exercise.pista.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DistanciaRecorrida  implements ValueObject<Integer> {
    private final int distancia;

    public DistanciaRecorrida(int distancia) {
        this.distancia = Objects.requireNonNull(distancia, "La distancia recorrida no puede estar nula");
    }

    @Override
    public Integer value() {
        return distancia;
    }
}