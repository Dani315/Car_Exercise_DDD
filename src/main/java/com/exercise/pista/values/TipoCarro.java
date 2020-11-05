package com.exercise.pista.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoCarro  implements ValueObject<TipoCarro.Propiedades> {
    private final String modelo;
    private final String color;

    public TipoCarro(String modelo, String color) {
        this.modelo = Objects.requireNonNull(modelo, "El modelo no puede estar nulo");
        this.color = Objects.requireNonNull(color, "El color no puede estar nulo");
    }

    @Override
    public Propiedades value() {
        return new Propiedades() {
            @Override
            public String modelo() {
                return modelo;
            }

            @Override
            public String color() {
                return color;
            }
        };
    }

    public interface Propiedades {
        String modelo();
        String color();
    }
}