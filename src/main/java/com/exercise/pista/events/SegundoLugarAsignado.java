package com.exercise.pista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.pista.entities.Carro;

public class SegundoLugarAsignado extends DomainEvent {
    private final Carro carroGanador;

    public SegundoLugarAsignado(Carro carroGanador) {
        super("com.exercise.pista.SegundoLugarAsignado");
        this.carroGanador = carroGanador;
    }

    public Carro getCarroGanador() {
        return carroGanador;
    }
}
