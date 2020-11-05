package com.exercise.pista.entities;

import co.com.sofka.domain.generic.Entity;
import com.exercise.pista.values.DistanciaRecorrida;
import com.exercise.pista.values.Placa;
import com.exercise.pista.values.TipoCarro;

public class Carro extends Entity<Placa> {
    protected Conductor conductor;
    protected DistanciaRecorrida distanciaRecorrida;
    protected TipoCarro tipoCarro;

    public Carro(Placa entityId, Conductor conductor,TipoCarro tipoCarro) {
        super(entityId);
        this.conductor = conductor;
        this.distanciaRecorrida = new DistanciaRecorrida(0);
        this.tipoCarro = tipoCarro;
    }

    public void avanzarMetros() {
        int metrosAvanzados = conductor.lanzarDado() * 100;
        distanciaRecorrida =  new DistanciaRecorrida(distanciaRecorrida.value() + metrosAvanzados);
    }

    public Conductor Conductor() {
        return conductor;
    }

    public DistanciaRecorrida DistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public TipoCarro TipoCarro() {
        return tipoCarro;
    }
}