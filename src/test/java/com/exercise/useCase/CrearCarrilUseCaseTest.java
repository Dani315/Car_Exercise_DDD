package com.exercise.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.exercise.pista.command.CrearCarrilCommand;
import com.exercise.pista.entities.Conductor;
import com.exercise.pista.events.CarrilCreado;
import com.exercise.pista.events.CarroAsignadoACarril;
import com.exercise.pista.events.PistaCreada;
import com.exercise.useCase.CrearCarrilUseCase;
import com.exercise.useCase.UseCaseHandleBaseTest;
import com.exercise.pista.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class CrearCarrilUseCaseTest  extends UseCaseHandleBaseTest {
    @Test
    void crearCarrilTest_happyPath() {
        var useCase = new CrearCarrilUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new PistaCreada(CodigoPista.of("101xxx"), 5)
        ));

        useCase.addRepository(repository);

        var request = new RequestCommand<>(new CrearCarrilCommand(
                CodigoPista.of("101xxx"),
                6000,
                new Placa(),
                new Conductor(new Cedula(), "Daniela Gaviria Mena",
                        new Informacion(20,"5 años")),
                new TipoCarro("2020", "dorado"),
                new NumeroCarril()
        ));

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("101xxx")
                .asyncExecutor(useCase, request)
                .subscribe(subscriber);

        verify(subscriber, times(2)).onNext(eventCaptor.capture());

        CarrilCreado carrilCreado = (CarrilCreado) eventCaptor.getAllValues().get(0);
        Assertions.assertEquals(6000, carrilCreado.getLimite());

        CarroAsignadoACarril carroAsignadoACarril = (CarroAsignadoACarril)eventCaptor.getAllValues().get(1);
        Assertions.assertEquals("Daniela Gaviria Mena", carroAsignadoACarril.getConductor().NombreCompleto());
        //verify(subscriber).onNext(eventCaptor.capture());
    }
}