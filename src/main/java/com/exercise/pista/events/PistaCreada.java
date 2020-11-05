package com.exercise.pista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.pista.values.CodigoPista;

public class PistaCreada extends DomainEvent {
    private final Integer topeCarriles;
    private final CodigoPista codigoPista;

    public PistaCreada( CodigoPista codigoPista, Integer topeCarriles) {
        super("com.exercise.pista.PistaCreada");
        this.topeCarriles = topeCarriles;
        this.codigoPista = codigoPista;
    }

    public Integer getTopeCarriles() {
        return topeCarriles;
    }

    public CodigoPista getCodigoPista() {
        return codigoPista;
    }
}
