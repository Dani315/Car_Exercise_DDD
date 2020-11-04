package com.exercise;

import co.com.sofka.domain.generic.EventChange;
import com.exercise.Events.CarroAsignado;
import com.exercise.Events.KilometrajeCambiado;
import com.exercise.Events.LimiteAsignado;
import com.exercise.VO.DistanciaRecorrida;

public class CarrilState extends EventChange {

    public CarrilState(Carril carril) {

        apply((CarroAsignado event) -> {
            carril.Carro = new Carro(event.getCarroId(), event.getConductor(), event.getTipoCarro());
        });

        apply((KilometrajeCambiado event) -> {
            Integer distancia = carril.Carro().conductor.lanzarDado() * 100;
            carril.Carro().distanciaRecorrida = new DistanciaRecorrida(carril.Carro.getDistanciaRecorrida().value() + distancia);
        });
        apply((LimiteAsignado event) -> {
            carril.limite = event.getLimite();
        });

    }

}
