package com.exercise.videoJuego.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.videoJuego.values.CodigoJuego;

public class PodiumActualizado extends DomainEvent {
    private final CodigoJuego codigoJuego;

    public PodiumActualizado(CodigoJuego codigoJuego) {
        super("com.exercise.videoJuego.PodiumActualizado");
        this.codigoJuego = codigoJuego;
    }

    public CodigoJuego getCodigoJuego() {
        return codigoJuego;
    }
}
