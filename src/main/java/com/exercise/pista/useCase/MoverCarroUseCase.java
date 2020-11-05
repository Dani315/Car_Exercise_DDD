package com.exercise.pista.useCase;

import co.com.sofka.business.annotation.EventListener;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.exercise.pista.Pista;
import com.exercise.pista.events.KilometrajeCambiado;

import java.util.logging.Logger;

@EventListener(eventType = "com.exercise.pista.KilometrajeCambiado")
public class MoverCarroUseCase extends UseCase<TriggeredEvent<KilometrajeCambiado>, ResponseEvents> {

    @Override
    public void  executeUseCase(TriggeredEvent<KilometrajeCambiado> triggeredEvent) {

        var event = triggeredEvent.getDomainEvent();

        var pista = Pista.from(event.getCodigoPista(), retrieveEvents());
        pista.MoverCarro(event.getNumeroCarril(), event.getCodigoPista());
        pista.MoverCarro(event.getNumeroCarril(), event.getCodigoPista());
        pista.MoverCarro(event.getNumeroCarril(), event.getCodigoPista());
        emit().onSuccess(new ResponseEvents(pista.getUncommittedChanges()));
    }
}

