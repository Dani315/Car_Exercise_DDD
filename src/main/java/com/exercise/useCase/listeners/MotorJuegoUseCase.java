package com.exercise.useCase.listeners;

import co.com.sofka.business.annotation.EventListener;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.pista.events.KilometrajeCambiado;
import com.exercise.pista.values.CodigoPista;
import com.exercise.pista.values.NumeroCarril;
import com.exercise.useCase.MoverCarroUseCase;
import com.exercise.useCase.ValidarCarroFinalizoRecorridoUseCase;
import com.exercise.useCase.model.CarroSobreCarril;
import com.exercise.useCase.services.CarrilCarroService;
import com.exercise.videoJuego.VideoJuego;
import com.exercise.videoJuego.events.RondaJugada;
import com.exercise.videoJuego.events.VideoJuegoEmpezado;
import com.exercise.videoJuego.values.CodigoJuego;

import java.util.List;
import java.util.concurrent.Flow;

@EventListener(eventType = "com.exercise.videoJuego.VideoJuegoEmpezado")
public class MotorJuegoUseCase extends UseCase<TriggeredEvent<VideoJuegoEmpezado>, ResponseEvents> {
    private final MoverCarroUseCase moverCarroUseCase;
    //private final ValidarCarroFinalizoRecorridoUseCase validarCarroFinalizoRecorridoUseCase;
    private final Flow.Subscriber<? super DomainEvent> subscriber;

    public MotorJuegoUseCase(MoverCarroUseCase moverCarroUseCase
            /*, ValidarCarroFinalizoRecorridoUseCase validarCarroFinalizoRecorridoUseCase*/,
                             Flow.Subscriber<? super DomainEvent> subscriber) {

        this.moverCarroUseCase = moverCarroUseCase;
        //this.validarCarroFinalizoRecorridoUseCase = validarCarroFinalizoRecorridoUseCase;
        this.subscriber = subscriber;
    }

    @Override
    public void executeUseCase(TriggeredEvent<VideoJuegoEmpezado> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();

        var codigoJuego = CodigoJuego.of(event.aggregateRootId());
        var videoJuego = VideoJuego.from((codigoJuego), retrieveEvents());

        boolean jugando;

        var service = getService(CarrilCarroService.class).orElseThrow();
        var competidores =  service.getCarrosSobreCarriles(codigoJuego);

        if(!competidores.isEmpty()) {
            do {
                competidores.forEach(carroSobreCarril -> {
                    KilometrajeCambiado event1 = new KilometrajeCambiado(carroSobreCarril.getNumeroCarril(), "101xxx");

                    UseCaseHandler.getInstance()
                            .setIdentifyExecutor(event1.getNumeroCarril().value())
                            .asyncExecutor(moverCarroUseCase, new TriggeredEvent<>(event1))
                            .subscribe(subscriber);
                    esperar2Segundos();

                    /*RondaJugada event2 = new RondaJugada(
                            CodigoJuego.of(codigoJuego.value()),
                            CodigoPista.of(carroSobreCarril.getPlaca()),
                            NumeroCarril.of(carroSobreCarril.getNumeroCarril()));

                    UseCaseHandler.getInstance()
                            .setIdentifyExecutor(codigoJuego.value())
                            .asyncExecutor(validarCarroFinalizoRecorridoUseCase, new TriggeredEvent<>(event2))
                            .subscribe(subscriber);
                    esperar2Segundos();*/
                });
                jugando = VideoJuego.from((codigoJuego), retrieveEvents()).isEstado();
            }while (jugando);
        }
        emit().onSuccess(new ResponseEvents(List.of()));
    }

    private void esperar2Segundos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
