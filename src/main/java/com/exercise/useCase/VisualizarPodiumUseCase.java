package com.exercise.useCase;

import co.com.sofka.business.annotation.EventListener;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.exercise.videoJuego.VideoJuego;
import com.exercise.videoJuego.events.PodiumActualizado;
import com.exercise.videoJuego.events.RondaJugada;

import java.util.logging.Level;
import java.util.logging.Logger;


@EventListener(eventType = "com.exercise.videoJuego.PodiumActualizado")
public class VisualizarPodiumUseCase  extends UseCase<TriggeredEvent<PodiumActualizado>, ResponseEvents> {

    private static final Logger logger = Logger.getLogger(com.exercise.useCase.VisualizarPodiumUseCase.class.getName());


    @Override
    public void executeUseCase(TriggeredEvent<PodiumActualizado> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();

        var videoJuego = VideoJuego.from(event.getCodigoJuego(),retrieveEvents());

        logger.log(Level.INFO, "Primer ganador "+videoJuego.getPodium().value().primerLugar().Conductor().NombreCompleto());
        logger.log(Level.INFO, "Segundo ganador "+videoJuego.getPodium().value().segundoLugar().Conductor().NombreCompleto());
        logger.log(Level.INFO, "Tecer ganador "+videoJuego.getPodium().value().tercerLugar().Conductor().NombreCompleto());

    }
}
