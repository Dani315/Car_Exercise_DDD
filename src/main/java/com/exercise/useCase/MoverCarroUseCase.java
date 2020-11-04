package com.exercise.useCase;

import co.com.sofka.business.annotation.EventListener;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.exercise.Carril;
import com.exercise.Events.KilometrajeCambiado;

import java.util.logging.Logger;

@EventListener(eventType = "com.exercise.KilometrajeCambiado")
public class MoverCarroUseCase extends UseCase<TriggeredEvent<KilometrajeCambiado>, ResponseEvents> {
    private static final Logger logger = Logger.getLogger(MoverCarroUseCase.class.getName());

    @Override
    public void executeUseCase(TriggeredEvent<KilometrajeCambiado> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();

        var carril = Carril.from(event.getNumeroCarril(), retrieveEvents());
        carril.moverCarro(event.getNumeroCarril());

        emit().onSuccess(new ResponseEvents(carril.getUncommittedChanges()));
    }
}
