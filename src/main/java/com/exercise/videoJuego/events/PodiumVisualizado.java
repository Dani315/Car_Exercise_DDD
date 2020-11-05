package com.exercise.videoJuego.events;

import co.com.sofka.domain.generic.DomainEvent;

public class PodiumVisualizado extends DomainEvent {
    public PodiumVisualizado(String type) {
        super("com.exercise.videoJuego.PodiumVisualizado");
    }
}
