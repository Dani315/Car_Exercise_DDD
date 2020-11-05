package com.exercise.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.exercise.pista.Pista;
import com.exercise.pista.command.CrearCarrilCommand;

public class CrearCarrilUseCase  extends UseCase<RequestCommand<CrearCarrilCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCarrilCommand> requestCommand) {
        var command = requestCommand.getCommand();

        Pista pista = Pista.from(command.getCodigoPista(), retrieveEvents());

        pista.crearCarril(command.getNumeroCarril(),command.getLimite());

        pista.AsignarCarroACarril(
                command.getPlaca(),
                command.getConductor(),
                command.getTipoCarro(),
                command.getNumeroCarril(),
                command.getCodigoPista());

        emit().onSuccess(new ResponseEvents(pista.getUncommittedChanges()));
    }
}