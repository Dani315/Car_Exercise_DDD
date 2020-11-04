package com.exercise.Events;

import co.com.sofka.domain.generic.DomainEvent;

public class LimiteAsignado extends DomainEvent {
    private final Integer limite;

    public LimiteAsignado(Integer limite) {
        super("com.exercise.AsignarLimiteACarril");
        this.limite = limite;
    }

    public Integer getLimite() {
        return limite;
    }
}
