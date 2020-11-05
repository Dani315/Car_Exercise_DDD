package com.exercise.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.exercise.pista.entities.Conductor;
import com.exercise.pista.events.CarrilCreado;
import com.exercise.pista.events.CarroAsignadoACarril;
import com.exercise.pista.events.KilometrajeCambiado;
import com.exercise.pista.events.PistaCreada;
import com.exercise.pista.values.*;
import com.exercise.videoJuego.events.RondaJugada;
import com.exercise.videoJuego.events.VideoJuegoCreado;
import com.exercise.videoJuego.events.VideoJuegoEmpezado;
import com.exercise.videoJuego.values.CodigoJuego;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ValidarCarroFinalizoRecorridoUseCaseTest  extends UseCaseHandleBaseTest {
    @Test
    void validarCarroFinalizoRecorridoTest_happyPath() {

        var useCase = new ValidarCarroFinalizoRecorridoUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new VideoJuegoCreado(),
                new VideoJuegoEmpezado(),
                new PistaCreada(CodigoPista.of("101xxx"), 5),
                new CarrilCreado(NumeroCarril.of("101"), 600),
                new CarroAsignadoACarril(Placa.of("MX5124"),
                        new Conductor(
                                new Cedula("1001359866"),"Daniela Gaviria Mena",
                                new Informacion(20, "5 años")),
                        new TipoCarro("2015", "Dorado"),
                        NumeroCarril.of("101"),
                        CodigoPista.of("101xxx")),
                new KilometrajeCambiado(NumeroCarril.of("101").value(), CodigoPista.of("101xxx").value()),
                new KilometrajeCambiado(NumeroCarril.of("101").value(), CodigoPista.of("101xxx").value()),
                new KilometrajeCambiado(NumeroCarril.of("101").value(), CodigoPista.of("101xxx").value())

        ));

        useCase.addRepository(repository);

        RondaJugada event = new RondaJugada(CodigoJuego.of("123"),CodigoPista.of("101xxx"), NumeroCarril.of("101"));

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("123")
                .asyncExecutor(useCase, new TriggeredEvent<>(event))
                .subscribe(subscriber);


        verify(subscriber).onComplete();
    }
}