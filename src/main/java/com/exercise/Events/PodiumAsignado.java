package com.exercise.Events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.VO.CarroId;


public class PodiumAsignado extends DomainEvent {
    private final CarroId carroId;

    public PodiumAsignado(CarroId carroId) {
        super("com.exercise.PodiumAsignado");
        this.carroId = carroId;
    }

    public CarroId getCarroId() {
        return carroId;
    }
}
