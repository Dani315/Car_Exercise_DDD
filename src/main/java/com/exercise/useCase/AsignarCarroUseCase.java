package com.exercise.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.exercise.Carril;
import com.exercise.Command.AsignarCarroCommand;

public class AsignarCarroUseCase extends UseCase<RequestCommand<AsignarCarroCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarCarroCommand> requestCommand) {
        var command = requestCommand.getCommand();

        Carril carril = Carril.from(command.getNumeroCarril(), retrieveEvents());
        carril.asignarCarro(command.getCarroId(), command.getConductor(), command.getTipoCarro());

        emit().onSuccess(new ResponseEvents(carril.getUncommittedChanges()));
    }
}



