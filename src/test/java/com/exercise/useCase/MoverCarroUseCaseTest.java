package com.exercise.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.exercise.pista.entities.Conductor;
import com.exercise.pista.events.CarrilCreado;
import com.exercise.pista.events.CarroAsignadoACarril;
import com.exercise.pista.events.KilometrajeCambiado;
import com.exercise.pista.events.PistaCreada;
import com.exercise.pista.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class MoverCarroUseCaseTest extends UseCaseHandleBaseTest {
    @Test
    void moverCarroTest_happyPath() {

        var useCase = new MoverCarroUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new PistaCreada(CodigoPista.of("101xxx"), 5),
                new CarrilCreado(NumeroCarril.of("101"), 6000),
                new CarroAsignadoACarril(Placa.of("MX5124"),
                        new Conductor(
                                new Cedula("1001359866"),"Daniela Gaviria Mena",
                                new Informacion(20, "5 años")),
                        new TipoCarro("2015", "Dorado"),
                        NumeroCarril.of("101"),
                        CodigoPista.of("101xxx"))
        ));

        useCase.addRepository(repository);

        KilometrajeCambiado event = new KilometrajeCambiado("101", "101xxx");

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("101")
                .asyncExecutor(useCase, new TriggeredEvent<>(event))
                .subscribe(subscriber);
        //verify(subscriber).onNext(eventCaptor.capture());
        verify(subscriber, times(3)).onNext(eventCaptor.capture());
        KilometrajeCambiado kmc = (KilometrajeCambiado)eventCaptor.getAllValues().get(0);
        Assertions.assertEquals("101", kmc.getNumeroCarril().value());
        Assertions.assertEquals("101xxx", kmc.getCodigoPista().value());
    }
}