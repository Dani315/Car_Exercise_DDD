package com.exercise.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import com.exercise.pista.command.CrearCarrilCommand;
import com.exercise.pista.entities.Conductor;
import com.exercise.pista.events.CarrilCreado;
import com.exercise.pista.events.CarroAsignadoACarril;
import com.exercise.pista.events.PistaCreada;
import com.exercise.pista.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AsignarCarroACarrilUseCaseTest  extends UseCaseHandleBaseTest {
    @Test
    void asignarCarroACarrilTest_happyPath() {
        var useCase = new AsignarCarroACarrilUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new PistaCreada(CodigoPista.of("101xxx"), 5),
                new CarrilCreado(NumeroCarril.of("101"), 6000)
        ));

        useCase.addRepository(repository);

        CarroAsignadoACarril event = new CarroAsignadoACarril(
                new Placa(),
                new Conductor(new Cedula(), "Daniela Gaviria Mena",
                        new Informacion(20,"5 años")),
                new TipoCarro("2020", "dorado"),
                NumeroCarril.of("101"),
                CodigoPista.of("101xxx")
        );

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("101xxx")
                .asyncExecutor(useCase, new TriggeredEvent<>(event))
                .subscribe(subscriber);

        verify(subscriber, times(1)).onNext(eventCaptor.capture());

        CarroAsignadoACarril carroAsignadoACarril = (CarroAsignadoACarril)eventCaptor.getAllValues().get(0);
        Assertions.assertEquals("Daniela Gaviria Mena", carroAsignadoACarril.getConductor().NombreCompleto());

    }
}