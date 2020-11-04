package com.exercise.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Incremental;
import com.exercise.VO.*;

public class KilometrajeCambiado extends DomainEvent implements Incremental {
    private final NumeroCarril numeroCarril;


    public KilometrajeCambiado(String numeroCarril) {
        super("com.exercise.KilometrajeCambiado");
        this.numeroCarril = new NumeroCarril(numeroCarril);
    }

    public NumeroCarril getNumeroCarril() {
        return numeroCarril;
    }
}
