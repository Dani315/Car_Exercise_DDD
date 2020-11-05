package com.exercise.pista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.pista.entities.Conductor;
import com.exercise.pista.values.CodigoPista;
import com.exercise.pista.values.NumeroCarril;
import com.exercise.pista.values.Placa;
import com.exercise.pista.values.TipoCarro;

public class CarroAsignadoACarril extends DomainEvent {
    private final Placa placa;
    private final Conductor conductor;
    private final TipoCarro tipoCarro;
    private final NumeroCarril numeroCarril;
    private final CodigoPista codigoPista;


    public CarroAsignadoACarril(Placa placa, Conductor conductor, TipoCarro tipoCarro, NumeroCarril numeroCarril, CodigoPista codigoPista) {
        super("com.exercise.pista.CarriAsignadoACarril");
        this.placa = placa;
        this.conductor = conductor;
        this.tipoCarro = tipoCarro;
        this.numeroCarril = numeroCarril;
        this.codigoPista = codigoPista;
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

    public CodigoPista getCodigoPista() {
        return codigoPista;
    }
}
