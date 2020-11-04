package com.exercise.Events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.Carril;
import com.exercise.VO.NumeroRonda;

import java.util.List;

public class RondaCreada extends DomainEvent {

    private final NumeroRonda numeroRonda;
    private final Integer cantidadCarriles;
    private final List<Carril> carrilList;

    public RondaCreada(NumeroRonda numeroRonda, Integer cantidadCarriles, List<Carril> carrilList) {
        super("com.exercise.RondaCreada");
        this.numeroRonda = numeroRonda;
        this.cantidadCarriles = cantidadCarriles;
        this.carrilList = carrilList;
    }

    public Integer getCantidadCarriles() {
        return cantidadCarriles;
    }

    public List<Carril> getCarrilList() {
        return carrilList;
    }

    public NumeroRonda getNumeroRonda() {
        return numeroRonda;
    }
}
