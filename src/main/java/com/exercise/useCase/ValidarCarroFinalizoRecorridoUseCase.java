package com.exercise.useCase;

import co.com.sofka.business.annotation.EventListener;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.exercise.Carril;
import com.exercise.Conductor;
import com.exercise.Events.RondaJugada;
import com.exercise.Ronda;

import java.util.logging.Level;
import java.util.logging.Logger;

@EventListener(eventType = "com.exercise.RondaJugada")
public class ValidarCarroFinalizoRecorridoUseCase extends UseCase<TriggeredEvent<RondaJugada>, ResponseEvents> {

    private static final Logger logger = Logger.getLogger(ValidarCarroFinalizoRecorridoUseCase.class.getName());

    @Override
    public void executeUseCase(TriggeredEvent<RondaJugada> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();

        var ronda = Ronda.from(event.getNumeroRonda(),retrieveEvents());

        Carril carril = Carril.from(event.getNumeroCarril(), retrieveEvents());

        carril.asignarCarro(event.getCarroId(),
                new Conductor(event.getCedula(), event.getNombreCompleto(), event.getInformacion()),
                event.getTipoCarro());
        carril.asignarLimiteAcarril(event.getLimite());
        carril.moverCarro(carril.identity());


        if(carril.Carro().getDistanciaRecorrida().value() >= carril.Limite()
            && ronda.getPodium().isPodiumDisponible()) {
            ronda.asignarAPodium(carril.Carro().identity());
            logger.log(Level.INFO, "El carro finalizó");
        }else {
            carril.moverCarro(carril.identity());
            carril.moverCarro(carril.identity());
            carril.moverCarro(carril.identity());
        }
        emit().onSuccess(new ResponseEvents(carril.getUncommittedChanges()));
    }
}
