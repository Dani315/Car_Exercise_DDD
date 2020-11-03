package com.exercise;


import co.com.sofka.domain.generic.Entity;
import com.exercise.VO.CarroId;
import com.exercise.VO.DistanciaRecorrida;
import com.exercise.VO.TipoCarro;

public class Carro extends Entity<CarroId> {
    protected  Conductor conductor;
    protected TipoCarro tipoCarro;
    protected DistanciaRecorrida distanciaRecorrida;

    public Carro(CarroId placa, Conductor conductor, TipoCarro tipoCarro) {
        super(placa);
        this.conductor = conductor;
        this.tipoCarro = tipoCarro;
        this.distanciaRecorrida = new DistanciaRecorrida(0);
    }

    public void avanzarMetros() {
        int metrosAvanzados = conductor.lanzarDado() * 100;
        distanciaRecorrida =  new DistanciaRecorrida(distanciaRecorrida.value() + metrosAvanzados);
    }

    public Conductor getConductor() {
        return conductor;
    }

    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public DistanciaRecorrida getDistanciaRecorrida() {
        return distanciaRecorrida;
    }
}
