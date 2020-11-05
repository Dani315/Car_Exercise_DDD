package com.exercise.pista;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.pista.entities.Carril;
import com.exercise.pista.entities.Conductor;
import com.exercise.pista.events.CarrilCreado;
import com.exercise.pista.events.CarroAsignadoACarril;
import com.exercise.pista.events.PistaCreada;
import com.exercise.pista.values.CodigoPista;
import com.exercise.pista.values.NumeroCarril;
import com.exercise.pista.values.Placa;
import com.exercise.pista.values.TipoCarro;

import java.util.List;

public class Pista extends AggregateEvent<CodigoPista> {
    List<Carril> listaCarriles;

    private Pista(CodigoPista entityId){
        super(entityId);
        subscribe(new PistaState(this));
    }

    public static Pista from(CodigoPista id, List<DomainEvent> events) {
        var pista = new Pista(id);
        events.forEach(pista::applyEvent);
        return pista;
    }

    public Pista(CodigoPista entityId, Integer topeCarriles) {
        super(entityId);
        appendChange(new PistaCreada(entityId,topeCarriles)).apply();
    }

    public void crearCarril(NumeroCarril numeroCarril, Integer limite) {
        appendChange(new CarrilCreado(numeroCarril, limite));
    }

    public void AsignarCarroACarril(Placa placa, Conductor conductor, TipoCarro tipoCarro, NumeroCarril numeroCarril) {
        appendChange(new CarroAsignadoACarril(placa,conductor,tipoCarro,numeroCarril));
    }
}