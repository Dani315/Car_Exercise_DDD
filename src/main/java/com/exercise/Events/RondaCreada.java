package com.exercise.Events;

import co.com.sofka.domain.generic.DomainEvent;

public class RondaCreada extends DomainEvent {

    private final Integer cantidadCarriles;

    public RondaCreada(Integer cantidadCarriles) {
        super("com.exercise.RondaCreada");
        this.cantidadCarriles = cantidadCarriles;
    }

    public Integer getCantidadCarriles() {
        return cantidadCarriles;
    }
}
