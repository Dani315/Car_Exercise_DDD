package com.exercise;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.generic.Identity;
import com.exercise.Events.CarrilCreado;
import com.exercise.Events.PodiumAsignado;
import com.exercise.Events.RondaCreada;
import com.exercise.VO.NumeroCarril;

import java.util.ArrayList;

public class RondaState extends EventChange {
    public RondaState(Ronda ronda) {
        apply((RondaCreada event) ->{
            ronda.listaCarriles = new ArrayList<>(event.getCantidadCarriles());
            ronda.limiteCarriles = event.getCantidadCarriles();
        });

        apply((CarrilCreado event) -> {
            ronda.listaCarriles.add(new Carril(new NumeroCarril(), event.getLimite()));
        });

        apply((PodiumAsignado event) -> {
                Carro carroganador = getJugador(ronda, event.getCarroId());
                if(ronda.podium.value().primerLugar() != null) {
                    ronda.podium = ronda.podium.asignarPrimerLugar(carroganador);
                }else if (ronda.podium.value().segundoLugar() != null) {
                    ronda.podium = ronda.podium.asignarSegundoLugar(carroganador);
                }else if (ronda.podium.value().tercerLugar() != null) {
                    ronda.podium = ronda.podium.asignarTercerLugar(carroganador);
                }else {
                    throw new IllegalArgumentException("No puede asignar al podio");
                }
        });

        /*apply((CarroAsignado carroAsignado)->{
            if(ronda.limiteCarriles > ronda.listaCarriles.size() ){
                ronda.listaCarriles.add(new Carril());
            }else{
                throw new IllegalArgumentException("la cantidad de carros es mayor a la permitida");
            }
        });*/
    }
    private Carro getJugador(Ronda ronda, Identity id) {
        return ronda.ListaCarriles()
                .stream()
                .filter(carril -> carril.Carro().identity().equals(id))
                .findFirst().get().Carro();
    }
}
