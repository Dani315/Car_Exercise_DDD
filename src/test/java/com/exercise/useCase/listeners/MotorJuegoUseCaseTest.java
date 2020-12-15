package com.exercise.useCase.listeners;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.pista.entities.Conductor;
import com.exercise.pista.events.CarrilCreado;
import com.exercise.pista.events.CarroAsignadoACarril;
import com.exercise.pista.events.PistaCreada;
import com.exercise.pista.values.*;
import com.exercise.useCase.MoverCarroUseCase;
import com.exercise.useCase.UseCaseHandleBaseTest;
import com.exercise.useCase.ValidarCarroFinalizoRecorridoUseCase;
import com.exercise.useCase.model.CarroSobreCarril;
import com.exercise.useCase.services.CarrilCarroService;
import com.exercise.videoJuego.events.VideoJuegoCreado;
import com.exercise.videoJuego.events.VideoJuegoEmpezado;
import com.exercise.videoJuego.values.CodigoJuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MotorJuegoUseCaseTest extends UseCaseHandleBaseTest {
    private static final String CODIGO_JUEGO = "fff-aaa-gggg";

    @Mock
    private CarrilCarroService carrilCarroService;

    @Spy
    private MoverCarroUseCase moverCarroUseCase;

    /*@Spy
    private ValidarCarroFinalizoRecorridoUseCase validarCarroFinalizoRecorridoUseCase;*/


    @BeforeEach
    public void setup(){
        var repository = mock(DomainEventRepository.class);
        when(repository.getEventsBy(any())).thenReturn(List.of(
               //new VideoJuegoCreado(new CodigoJuego(CODIGO_JUEGO)),
                new PistaCreada(CodigoPista.of("101xxx"), 5),
                new CarrilCreado(NumeroCarril.of("101"), 6000),
                new CarroAsignadoACarril(Placa.of("MX5124"),
                        new Conductor(
                                new Cedula("1001359866"),"Daniela Gaviria Mena",
                                new Informacion(20, "5 años")),
                        new TipoCarro("2015", "Dorado"),
                        NumeroCarril.of("101"),
                        CodigoPista.of("101xxx")),
                new CarrilCreado(NumeroCarril.of("102"), 6000),
                        new CarroAsignadoACarril(Placa.of("MX5125"),
                                new Conductor(
                                        new Cedula("1001359866"),"Luisa Gaviria Mena",
                                        new Informacion(20, "5 años")),
                                new TipoCarro("2015", "Dorado"),
                                NumeroCarril.of("102"),
                                CodigoPista.of("101xxx"))
        ));

        moverCarroUseCase.addRepository(repository);
        //validarCarroFinalizoRecorridoUseCase.addRepository(repository);
    }

    @Test
    void correrVideoJuego(){
        var videoJuegoEmpezado = new VideoJuegoEmpezado();
        videoJuegoEmpezado.setAggregateRootId(CODIGO_JUEGO);

        when(repository.getEventsBy(anyString())).thenAnswer(new Answer<List<DomainEvent>>() {
            @Override
            public List<DomainEvent> answer(InvocationOnMock invocationOnMock)  {
                    return List.of(
                            new VideoJuegoCreado(new CodigoJuego(CODIGO_JUEGO)),
                            new VideoJuegoEmpezado()
                    );
            }
        });

        when(carrilCarroService.getCarrosSobreCarriles(any())).thenReturn(List.of(
                new CarroSobreCarril("MX5124", "101"),
                new CarroSobreCarril("MX5125", "102")
        ));


        var motorJuegoUseCase = new MotorJuegoUseCase(moverCarroUseCase/*, validarCarroFinalizoRecorridoUseCase*/, subscriber);
        motorJuegoUseCase.addRepository(repository);
        motorJuegoUseCase.addServiceBuilder(
                new ServiceBuilder()
                        .addService(carrilCarroService)
        );

        //accion
        UseCaseHandler.getInstance()
                .setIdentifyExecutor(CODIGO_JUEGO)
                .asyncExecutor(motorJuegoUseCase, new TriggeredEvent<>(videoJuegoEmpezado))
                .subscribe(subscriber);

        //verify(subscriber).onComplete();
        verify(subscriber, times(1)).onNext(eventCaptor.capture());

    }
}