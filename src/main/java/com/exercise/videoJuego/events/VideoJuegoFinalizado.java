package com.exercise.videoJuego.events;

import co.com.sofka.domain.generic.DomainEvent;

public class VideoJuegoFinalizado  extends DomainEvent {
    public VideoJuegoFinalizado() {
        super("com.exercise.videoJuego.VideoJuegoFinalizado");
    }
}
