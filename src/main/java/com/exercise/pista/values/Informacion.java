package com.exercise.pista.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Informacion implements ValueObject<Informacion.Propiedades> {
    private final Integer edad;
    private final String experiencia;

    public Informacion(Integer edad, String experiencia) {
        this.experiencia = Objects.requireNonNull(experiencia, "La experiencia no puede estar nula");
        this.edad = Objects.requireNonNull(edad, "La edad no puede estar nula");
    }

    @Override
    public Propiedades value() {
        return new Propiedades() {
            @Override
            public Integer edad() {
                return edad;
            }

            @Override
            public String experiencia() {
                return experiencia;
            }
        };
    }

    public interface Propiedades {
        Integer edad();
        String experiencia();
    }
}
