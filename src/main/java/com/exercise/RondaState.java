package com.exercise;

import co.com.sofka.domain.generic.EventChange;
import com.exercise.Events.RondaCreada;

import java.util.ArrayList;

public class RondaState extends EventChange {
    public RondaState(Ronda ronda) {
        apply((RondaCreada event) ->{
            ronda.listaCarriles = new ArrayList<>(event.getCantidadCarriles());
            ronda.limiteCarriles = event.getCantidadCarriles();
        });
    }
}
