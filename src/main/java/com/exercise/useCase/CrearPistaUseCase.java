package com.exercise.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.exercise.pista.Pista;
import com.exercise.pista.command.CrearPistaCommand;
import com.exercise.pista.values.CodigoPista;

public class CrearPistaUseCase extends UseCase<RequestCommand<CrearPistaCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPistaCommand> requestCommand) {
        var command = requestCommand.getCommand();

        Pista pista = new Pista(new CodigoPista(command.getCodigoPista().value()) ,command.getTopeCarriles());

        emit().onSuccess(new ResponseEvents(pista.getUncommittedChanges()));
    }
}
