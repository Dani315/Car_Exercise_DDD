package com.exercise;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.Events.CarrilCreado;
import com.exercise.Events.PodiumAsignado;
import com.exercise.Events.RondaCreada;
import com.exercise.VO.CarroId;
import com.exercise.VO.NumeroCarril;
import com.exercise.VO.NumeroRonda;
import com.exercise.VO.Podium;

import java.util.List;

public class Ronda  extends AggregateEvent<NumeroRonda> {

    protected List<Carril> listaCarriles;
    protected  Integer limiteCarriles;
    protected Podium podium;

    public Ronda(NumeroRonda entityId, Integer limiteCarriles, List<Carril> listaCarriles) {
        super(entityId);
        appendChange(new RondaCreada(entityId, limiteCarriles, listaCarriles)).apply();
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

    public void asignarAPodium(CarroId carro) {
        appendChange( new PodiumAsignado(carro)).apply();
    }

    public List<Carril> ListaCarriles() {
        return listaCarriles;
    }

    public Integer LimiteCarriles() {
        return limiteCarriles;
    }

    public Podium getPodium() {
        return podium;
    }
}
