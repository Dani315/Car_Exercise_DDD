package com.exercise.pista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.pista.entities.Carro;

public class PrimerLugarAsignado extends DomainEvent {
    private final Carro carroGanador;

    public PrimerLugarAsignado(Carro carroGanador) {
        super("com.exercise.pista.PrimerLugarAsignado");
        this.carroGanador = carroGanador;
    }

    public Carro getCarroGanador() {
        return carroGanador;
    }
}
