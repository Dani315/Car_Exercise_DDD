package com.exercise.videoJuego.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.videoJuego.values.CodigoJuego;

public class VideoJuegoCreado extends DomainEvent {
    private final CodigoJuego codigoJuego;

    public VideoJuegoCreado() {
        super("com.exercise.videoJuego.VideoJuegoCreado");
        this.codigoJuego = null;
    }

    public VideoJuegoCreado(CodigoJuego codigoJuego) {
        super("com.exercise.videoJuego.VideoJuegoCreado");
        this.codigoJuego = codigoJuego;
    }
}
