package com.exercise.pista.command;

import co.com.sofka.domain.generic.Command;
import com.exercise.pista.values.CodigoPista;

public class CrearPistaCommand implements Command {

    private Integer topeCarriles;
    private CodigoPista codigoPista;

    public CrearPistaCommand(CodigoPista codigoPista, Integer topeCarriles) {
        this.topeCarriles = topeCarriles;
        this.codigoPista = codigoPista;
    }

    public CrearPistaCommand() {
    }

    public Integer getTopeCarriles() {
        return topeCarriles;
    }

    public CodigoPista getCodigoPista() {
        return codigoPista;
    }
}
