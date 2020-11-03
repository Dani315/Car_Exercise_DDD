package com.exercise;

import co.com.sofka.domain.generic.EventChange;
import com.exercise.Events.CarrilCreado;
import com.exercise.Events.CarroAsignado;
import com.exercise.Events.KilometrajeCambiado;
import com.exercise.VO.DistanciaRecorrida;

import java.util.Objects;

public class CarrilState extends EventChange {

    public CarrilState(Carril carril) {

        apply((CarrilCreado event) -> {
            carril.limite = event.getLimite();
        });

        apply((CarroAsignado event) -> {
            carril.Carro = new Carro(event.getCarroId(), event.getConductor(), event.getTipoCarro());
        });

        apply((KilometrajeCambiado event) -> {
            var distancia = event.getDistancia();
            Objects.requireNonNull(distancia, "La distancia no puede ser null");
            if(distancia <= 0) {
                throw new IllegalArgumentException("No puede ser negativo o cero el valod de la distancia");
            }
            carril.Carro().distanciaRecorrida = new DistanciaRecorrida(carril.Carro.getDistanciaRecorrida().value() + distancia);
        });
    }
}
