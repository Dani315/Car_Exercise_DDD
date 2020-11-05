package com.exercise.videoJuego.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.videoJuego.values.CodigoJuego;

public class VideoJuegoCreado extends DomainEvent {
    private final boolean estado;

    public VideoJuegoCreado(boolean estado) {
        super("com.exercise.videoJuego.VideoJuegoCreado");
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }
}
