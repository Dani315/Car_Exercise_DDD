package com.exercise.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.exercise.pista.entities.Carro;
import com.exercise.pista.entities.Conductor;
import com.exercise.pista.events.CarrilCreado;
import com.exercise.pista.events.CarroAsignadoACarril;
import com.exercise.pista.events.KilometrajeCambiado;
import com.exercise.pista.events.PistaCreada;
import com.exercise.pista.values.*;
import com.exercise.videoJuego.events.*;
import com.exercise.videoJuego.values.CodigoJuego;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class VisualizarPodiumUseCaseTest  extends UseCaseHandleBaseTest {
    @Test
    void visualizarPodiumTest_happyPath() {

        var useCase = new VisualizarPodiumUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new VideoJuegoCreado(),
                new PrimerLugarAsignado(
                    new Carro(Placa.of("MX5124"),
                    new Conductor(Cedula.of("10013509866"), "Daniela Gaviria",
                            new Informacion(20,"5 años")),
                    new TipoCarro("2020", "Azul"))),
                new SegundoLugarAsignado(
                    new Carro(Placa.of("MX5125"),
                    new Conductor(Cedula.of("10013509855"), "Jose Gaviria",
                            new Informacion(18,"3 años")),
                    new TipoCarro("2020", "Dorado"))),
                new TercerLugarAsignado(
                    new Carro(Placa.of("MX5126"),
                    new Conductor(Cedula.of("10013509899"), "Norberto Gaviria",
                            new Informacion(48,"23 años")),
                    new TipoCarro("2020", "Mate")))

        ));

        useCase.addRepository(repository);

        PodiumActualizado event = new PodiumActualizado(CodigoJuego.of("123"));

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("123")
                .asyncExecutor(useCase, new TriggeredEvent<>(event))
                .subscribe(subscriber);


        verify(subscriber).onComplete();
    }
}