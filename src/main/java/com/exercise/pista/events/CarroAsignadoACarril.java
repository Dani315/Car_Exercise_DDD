package com.exercise.pista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.pista.entities.Conductor;
import com.exercise.pista.values.NumeroCarril;
import com.exercise.pista.values.Placa;
import com.exercise.pista.values.TipoCarro;

public class CarroAsignadoACarril extends DomainEvent {
    private final Placa placa;
    private final Conductor conductor;
    private final TipoCarro tipoCarro;
    private final NumeroCarril numeroCarril;

    public CarroAsignadoACarril(Placa placa, Conductor conductor, TipoCarro tipoCarro, NumeroCarril numeroCarril) {
        super("com.exercise.pista.CarriAsignadoACarril");
        this.placa = placa;
        this.conductor = conductor;
        this.tipoCarro = tipoCarro;
        this.numeroCarril = numeroCarril;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public NumeroCarril getNumeroCarril() {
        return numeroCarril;
    }
}
