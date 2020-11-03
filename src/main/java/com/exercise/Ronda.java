package com.exercise;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.Events.CarrilCreado;
import com.exercise.Events.RondaCreada;
import com.exercise.VO.NumeroCarril;
import com.exercise.VO.NumeroRonda;

import java.util.List;

public class Ronda  extends AggregateEvent<NumeroRonda> {

    protected List<Carril> listaCarriles;
    protected  Integer limiteCarriles;

    public Ronda(NumeroRonda entityId, Integer limiteCarriles) {
        super(entityId);
        appendChange(new RondaCreada(limiteCarriles)).apply();
    }

    private Ronda(NumeroRonda entityId) {
        super(entityId);
        subscribe(new RondaState(this));
    }

    public static Ronda from(NumeroRonda entityId, List<DomainEvent> events){
        var ronda = new Ronda(entityId);
        events.forEach(ronda::applyEvent);
        return  ronda;
    }

    public void agregarCarril(NumeroCarril numeroCarril, Integer limite){
        appendChange( new CarrilCreado(numeroCarril, limite)).apply();
    }


}
