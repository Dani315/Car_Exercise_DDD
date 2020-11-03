package com.exercise.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Incremental;

public class KilometrajeCambiado extends DomainEvent implements Incremental {
    private final Integer distancia;

    public KilometrajeCambiado(Integer distancia) {
        super("com.exercise.KilometrajeCambiado");
        this.distancia = distancia;
    }

    public Integer getDistancia() {
        return distancia;
    }
}
