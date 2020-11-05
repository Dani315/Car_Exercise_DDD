package com.exercise.videoJuego.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.pista.values.CodigoPista;
import com.exercise.pista.values.NumeroCarril;
import com.exercise.videoJuego.values.CodigoJuego;

public class RondaJugada extends DomainEvent {
    private final CodigoJuego codigoJuego;
    private  final CodigoPista codigoPista;
    private final NumeroCarril numeroCarril;

    public RondaJugada(CodigoJuego codigoJuego, CodigoPista codigoPista, NumeroCarril numeroCarril) {
        super("com.exercise.videoJuego.RondaJugada");
        this.codigoJuego = codigoJuego;
        this.codigoPista = codigoPista;
        this.numeroCarril = numeroCarril;
    }

    public CodigoJuego getCodigoJuego() {
        return codigoJuego;
    }

    public CodigoPista getCodigoPista() {
        return codigoPista;
    }

    public NumeroCarril getNumeroCarril() {
        return numeroCarril;
    }
}
