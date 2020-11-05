package com.exercise.pista.command;

import co.com.sofka.domain.generic.Command;
import com.exercise.pista.entities.Conductor;
import com.exercise.pista.values.CodigoPista;
import com.exercise.pista.values.NumeroCarril;
import com.exercise.pista.values.Placa;
import com.exercise.pista.values.TipoCarro;

public class CrearCarrilCommand implements Command {
    private CodigoPista codigoPista;
    private Integer limite;
    private Placa placa;
    private Conductor conductor;
    private TipoCarro tipoCarro;
    private NumeroCarril numeroCarril;

    public CrearCarrilCommand(CodigoPista codigoPista, Integer limite, Placa placa, Conductor conductor, TipoCarro tipoCarro, NumeroCarril numeroCarril) {
        this.codigoPista = codigoPista;
        this.limite = limite;
        this.placa = placa;
        this.conductor = conductor;
        this.tipoCarro = tipoCarro;
        this.numeroCarril = numeroCarril;
    }

    public CrearCarrilCommand() {
    }

    public Integer getLimite() {
        return limite;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public NumeroCarril getNumeroCarril() {
        return numeroCarril;
    }

    public CodigoPista getCodigoPista() {
        return codigoPista;
    }
}
