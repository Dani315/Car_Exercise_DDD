package com.exercise.videoJuego.values;

import co.com.sofka.domain.generic.Identity;
import com.exercise.pista.values.Cedula;

import javax.swing.text.html.parser.Entity;

public class CodigoJuego extends Identity {
    public CodigoJuego() {}

    public CodigoJuego(String codigoJuego) {
        super(codigoJuego);
    }

    public static CodigoJuego of(String codigoJuego) {
        return new CodigoJuego(codigoJuego);
    }
}
