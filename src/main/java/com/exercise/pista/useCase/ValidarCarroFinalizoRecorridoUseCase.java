package com.exercise.pista.useCase;

import co.com.sofka.business.annotation.EventListener;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.exercise.pista.Pista;
import com.exercise.videoJuego.VideoJuego;
import com.exercise.videoJuego.events.RondaJugada;

import java.util.logging.Level;
import java.util.logging.Logger;

@EventListener(eventType = "com.exercise.videoJuego.RondaJugada")
public class ValidarCarroFinalizoRecorridoUseCase extends UseCase<TriggeredEvent<RondaJugada>, ResponseEvents> {

    private static final Logger logger = Logger.getLogger(ValidarCarroFinalizoRecorridoUseCase.class.getName());

    @Override
    public void executeUseCase(TriggeredEvent<RondaJugada> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();

        var videoJuego = VideoJuego.from(event.getCodigoJuego(),retrieveEvents());
        var pista = Pista.from(event.getCodigoPista(), retrieveEvents());

        var carril = pista.getListaCarriles()
                .stream()
                .filter(carril1 -> carril1.identity().equals(event.getNumeroCarril()))
                .findFirst()
                .get();

            if(carril.Carro().DistanciaRecorrida().value() >= carril.Limite()
                    && videoJuego.getPodium().isPodiumDisponible()) {
                if (videoJuego.getPodium().value().primerLugar() != null) {
                    videoJuego.asignarPrimerLugar(carril.Carro());
                } else {
                    if (videoJuego.getPodium().value().segundoLugar() != null) {
                        videoJuego.asignarSegundoLugar(carril.Carro());
                    } else {
                        videoJuego.asignarTercerLugar(carril.Carro());
                        videoJuego.finalizarVideoJuego();
                    }
                }
                logger.log(Level.INFO, "El carro finalizó su recorrido");
            }else {
                logger.log(Level.INFO, "El carro no finalizó  su recorrido");
            }

        emit().onSuccess(new ResponseEvents(pista.getUncommittedChanges()));
    }
}
