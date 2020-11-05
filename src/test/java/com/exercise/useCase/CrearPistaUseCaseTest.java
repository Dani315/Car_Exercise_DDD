package com.exercise.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.exercise.pista.command.CrearPistaCommand;
import com.exercise.pista.events.PistaCreada;
import com.exercise.useCase.CrearPistaUseCase;
import com.exercise.useCase.UseCaseHandleBaseTest;
import com.exercise.pista.values.CodigoPista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class CrearPistaUseCaseTest extends UseCaseHandleBaseTest {
    @Test
    void crearPistaTest_happyPath() {
        var useCase = new CrearPistaUseCase();

        var request = new RequestCommand<>(new CrearPistaCommand(
                new CodigoPista("101"),
                5
        ));

        UseCaseHandler.getInstance()
                .asyncExecutor(useCase, request)
                .subscribe(subscriber);

        verify(subscriber).onNext(eventCaptor.capture());

        PistaCreada pistaCreada = (PistaCreada) eventCaptor.getAllValues().get(0);
        Assertions.assertEquals("101", pistaCreada.getCodigoPista().value());
        Assertions.assertEquals(5, pistaCreada.getTopeCarriles());
    }
}