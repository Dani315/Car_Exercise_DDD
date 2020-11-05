package com.exercise.pista.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Incremental;
import com.exercise.pista.values.CodigoPista;
import com.exercise.pista.values.NumeroCarril;

public class KilometrajeCambiado extends DomainEvent implements Incremental {
    private final NumeroCarril numeroCarril;
    private final CodigoPista codigoPista;

    public KilometrajeCambiado(String numeroCarril, String codigoPista) {
        super("com.exercise.pista.KilometrajeCambiado");
        this.numeroCarril = new NumeroCarril(numeroCarril);
        this.codigoPista = new CodigoPista(codigoPista);
    }

    public NumeroCarril getNumeroCarril() {
        return numeroCarril;
    }

    public CodigoPista getCodigoPista() {
        return codigoPista;
    }
}
