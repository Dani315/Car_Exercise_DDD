package com.exercise.Events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Incremental;
import com.exercise.VO.*;

public class RondaJugada  extends DomainEvent implements Incremental {
    private final NumeroCarril numeroCarril;
    private final CarroId carroId;
    private final Cedula cedula;
    private final String nombreCompleto;
    private final Informacion informacion;
    private final TipoCarro tipoCarro;
    private final Integer limite;
    private final NumeroRonda numeroRonda;

    public RondaJugada(NumeroCarril numeroCarril, Integer limite, CarroId carroId, Cedula cedula, String nombreCompleto, Informacion informacion, TipoCarro tipoCarro, NumeroRonda numeroRonda) {
        super("com.exercise.RondaJugada");
        this.numeroCarril = numeroCarril;
        this.carroId = carroId;
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.informacion = informacion;
        this.tipoCarro = tipoCarro;
        this.limite = limite;
        this.numeroRonda = numeroRonda;
    }

    public NumeroCarril getNumeroCarril() {
        return numeroCarril;
    }

    public CarroId getCarroId() {
        return carroId;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Informacion getInformacion() {
        return informacion;
    }

    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public Integer getLimite() {
        return limite;
    }

    public NumeroRonda getNumeroRonda() {
        return numeroRonda;
    }
}
