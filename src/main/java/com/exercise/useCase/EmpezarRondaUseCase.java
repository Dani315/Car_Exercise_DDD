package com.exercise.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.exercise.Command.EmpezarRondaCommand;
import com.exercise.VO.NumeroRonda;
import com.exercise.Ronda;

public class EmpezarRondaUseCase extends UseCase<RequestCommand<EmpezarRondaCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EmpezarRondaCommand> requestCommand) {
        var command = requestCommand.getCommand();

        Ronda ronda = new Ronda(new NumeroRonda(), command.getCantidadCarriles());

        command.getCarrilList().forEach((carril) -> {
            ronda.agregarCarril(carril.identity(), carril.Limite());
        });

        emit().onSuccess(new ResponseEvents(ronda.getUncommittedChanges()));
    }
}
