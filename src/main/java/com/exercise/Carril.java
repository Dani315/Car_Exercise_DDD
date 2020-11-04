package com.exercise;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.Events.CarrilCreado;
import com.exercise.Events.CarroAsignado;
import com.exercise.Events.KilometrajeCambiado;
import com.exercise.Events.LimiteAsignado;
import com.exercise.VO.CarroId;
import com.exercise.VO.NumeroCarril;
import com.exercise.VO.TipoCarro;

import java.util.List;

public class Carril extends AggregateEvent<NumeroCarril> {

    protected Integer limite;
    protected com.exercise.Carro Carro;

    private Carril(NumeroCarril numeroCarril){
        super(numeroCarril);
        subscribe(new CarrilState(this));
    }

    public Carril(NumeroCarril numeroCarril, Integer limite) {
        super(numeroCarril);
        appendChange(new CarrilCreado(numeroCarril, limite)).apply();
    }

    public static Carril from(NumeroCarril numeroCarril, List<DomainEvent> events){
        var carril = new Carril(numeroCarril);
        events.forEach(carril::applyEvent);
        return carril;
    }

    public void asignarCarro(CarroId carroId, Conductor conductor, TipoCarro tipoCarro) {
        appendChange(new CarroAsignado(carroId, conductor, tipoCarro)).apply();
    }

    public void asignarLimiteAcarril(Integer limite) {
        appendChange(new LimiteAsignado(limite)).apply();
    }

    public void moverCarro(NumeroCarril numeroCarril) {
        appendChange(new KilometrajeCambiado(numeroCarril.value())).apply();
    }

    public Integer Limite() {
        return limite;
    }

    public Carro Carro() {
        return Carro;
    }
}
