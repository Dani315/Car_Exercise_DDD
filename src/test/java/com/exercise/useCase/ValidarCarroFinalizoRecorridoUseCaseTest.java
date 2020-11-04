package com.exercise.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.exercise.Carril;
import com.exercise.Events.CarrilCreado;
import com.exercise.Events.RondaCreada;
import com.exercise.Events.RondaJugada;
import com.exercise.VO.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ValidarCarroFinalizoRecorridoUseCaseTest extends UseCaseHandleBaseTest{
    @Test
    void validarCarroLlegoAlaMetaTest_happyPath()  {

        var useCase = new ValidarCarroFinalizoRecorridoUseCase();

        List<Carril> carriles = new ArrayList<>();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new RondaCreada(NumeroRonda.of("1"),1, carriles),
                new CarrilCreado(NumeroCarril.of("101"), 6000)
        ));

        useCase.addRepository(repository);

        RondaJugada event = new RondaJugada(
                NumeroCarril.of("101"),
                6000,
                CarroId.of("MX5124"),
                Cedula.of("1001359866"),
                "Daniela Gaviria Mena",
                new Informacion(20, "5 años"),
                new TipoCarro("2015", "Dorado"),
                NumeroRonda.of("1"));

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("101")
                .asyncExecutor(useCase, new TriggeredEvent<>(event))
                .subscribe(subscriber);

        verify(subscriber, times(6)).onNext(eventCaptor.capture());
    }
}