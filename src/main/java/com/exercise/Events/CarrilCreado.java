package com.exercise.Events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.VO.NumeroCarril;

public class CarrilCreado extends DomainEvent {
    private final NumeroCarril numeroCarril;
    private final Integer limite;

    public CarrilCreado(NumeroCarril numeroCarril, Integer limite) {
        super("com.exercise.CarrilCreado");
        this.numeroCarril = numeroCarril;
        this.limite = limite;
    }

    public NumeroCarril getNumeroCarril() {
        return numeroCarril;
    }

    public Integer getLimite() {
        return limite;
    }
}
