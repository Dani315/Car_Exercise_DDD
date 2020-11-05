package com.exercise.videoJuego.events;

import co.com.sofka.domain.generic.DomainEvent;

public class VideoJuegoEmpezado extends DomainEvent {
    public VideoJuegoEmpezado() {
        super("com.exercise.videoJuego.VideoJuegoEmpezado");
    }
}
