package com.exercise.useCase;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.exercise.Carril;
import com.exercise.Command.CrearCarrilCommand;
import com.exercise.Command.EmpezarRondaCommand;
import com.exercise.Events.RondaCreada;
import com.exercise.VO.CarroId;
import com.exercise.VO.NumeroCarril;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class EmpezarRondaUseCaseTest extends UseCaseHandleBaseTest{

    @Test
    void empezarRondaTest_happyPath() {
        var useCase = new EmpezarRondaUseCase();
        List<Carril> listaCarriles = new ArrayList<>();

        listaCarriles.add(new Carril(new NumeroCarril("101"), 60000));
        listaCarriles.add(new Carril(new NumeroCarril("102"), 60000));

        var command = new EmpezarRondaCommand(
                listaCarriles,listaCarriles.size()
        );

        UseCaseHandler.getInstance().asyncExecutor(useCase, new RequestCommand<>(command))
                .subscribe(subscriber);

        verify(subscriber, times(3)).onNext(eventCaptor.capture());
        RondaCreada rondaCreada = (RondaCreada) eventCaptor.getAllValues().get(0);

        Assertions.assertEquals(2, rondaCreada.getCantidadCarriles());

    }
}