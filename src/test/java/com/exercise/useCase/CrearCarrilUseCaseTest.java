package com.exercise.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.exercise.Command.CrearCarrilCommand;
import com.exercise.Events.CarrilCreado;
import com.exercise.VO.NumeroCarril;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.verify;

class CrearCarrilUseCaseTest extends UseCaseHandleBaseTest{
    @Test
    void crearcarrilTest_happyPath() {
        var useCase = new CrearCarrilUseCase();

        var request = new RequestCommand<>(new CrearCarrilCommand(
                new NumeroCarril("101"),
                6000
        ));

        //act
        UseCaseHandler.getInstance()
                .asyncExecutor(useCase, request)
                .subscribe(subscriber);

        verify(subscriber).onNext(eventCaptor.capture());

        CarrilCreado carrilCreado = (CarrilCreado) eventCaptor.getAllValues().get(0);
        Assertions.assertEquals("101", carrilCreado.getNumeroCarril().value());
    }

}