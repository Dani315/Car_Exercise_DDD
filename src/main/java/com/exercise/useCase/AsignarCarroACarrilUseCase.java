package com.exercise.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.exercise.pista.Pista;
import com.exercise.pista.events.CarroAsignadoACarril;

public class AsignarCarroACarrilUseCase extends UseCase<TriggeredEvent<CarroAsignadoACarril>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CarroAsignadoACarril> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();

        Pista pista = Pista.from(event.getCodigoPista(), retrieveEvents());

        pista.AsignarCarroACarril(
                event.getPlaca(),
                event.getConductor(),
                event.getTipoCarro(),
                event.getNumeroCarril(),
                event.getCodigoPista());

        emit().onSuccess(new ResponseEvents(pista.getUncommittedChanges()));
    }
}
