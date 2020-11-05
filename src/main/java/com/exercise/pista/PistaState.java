package com.exercise.pista;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.generic.Identity;
import com.exercise.pista.entities.Carril;
import com.exercise.pista.entities.Carro;
import com.exercise.pista.events.CarrilCreado;
import com.exercise.pista.events.CarroAsignadoACarril;
import com.exercise.pista.events.KilometrajeCambiado;
import com.exercise.pista.events.PistaCreada;
import com.exercise.pista.values.TipoCarro;

import java.util.ArrayList;

public class PistaState  extends EventChange {
    public PistaState(Pista pista) {

        apply((PistaCreada event) -> {
            pista.listaCarriles = new ArrayList<>(event.getTopeCarriles());
        });

        apply((CarrilCreado event) -> {
            pista.listaCarriles.add(new Carril(event.getNumeroCarril(), event.getLimite()));
        });

        apply((CarroAsignadoACarril event) -> {
            Carril carril = getCarril(pista, event.getNumeroCarril());
            carril.asignarCarro(new Carro(event.getPlaca(),
                    event.getConductor(),
                    new TipoCarro(event.getTipoCarro().value().modelo(), event.getTipoCarro().value().color())));
        });

        apply((KilometrajeCambiado event) -> {
            Carril carril = getCarril(pista, event.getNumeroCarril());
            carril.Carro().avanzarMetros();
        });
    }

    private Carril getCarril(Pista pista, Identity id) {
        return pista.listaCarriles
                .stream()
                .filter(carril -> carril.identity().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("El carril no existe"));
    }
}

