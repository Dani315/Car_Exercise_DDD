package com.exercise.videoJuego.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.pista.entities.Carro;

public class TercerLugarAsignado extends DomainEvent {
    private final Carro carroGanador;

    public TercerLugarAsignado(Carro carroGanador) {
        super("com.exercise.pista.TercerLugarAsignado");
        this.carroGanador = carroGanador;
    }

    public Carro getCarroGanador() {
        return carroGanador;
    }
}
