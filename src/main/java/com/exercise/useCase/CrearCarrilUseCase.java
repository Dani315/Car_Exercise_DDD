package com.exercise.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.exercise.Carril;
import com.exercise.Command.CrearCarrilCommand;

public class CrearCarrilUseCase extends UseCase<RequestCommand<CrearCarrilCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCarrilCommand> requestCommand) {
        var command = requestCommand.getCommand();

        Carril carril = new Carril(command.getNumeroCarril(), command.getLimite());

        emit().onSuccess(new ResponseEvents(carril.getUncommittedChanges()));
    }
}
