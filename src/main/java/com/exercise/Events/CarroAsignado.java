package com.exercise.Events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.Conductor;
import com.exercise.VO.CarroId;
import com.exercise.VO.TipoCarro;

public class CarroAsignado extends DomainEvent {
    private final CarroId carroId;
    private final Conductor conductor;
    private final TipoCarro tipoCarro;

    public CarroAsignado(CarroId carroId, Conductor conductor, TipoCarro tipoCarro) {
        super("com.exercise.CarroAsignado");
        this.carroId = carroId;
        this.conductor = conductor;
        this.tipoCarro = tipoCarro;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public CarroId getCarroId() {
        return carroId;
    }
}
