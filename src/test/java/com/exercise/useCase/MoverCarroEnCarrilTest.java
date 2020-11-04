package com.exercise.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.exercise.Conductor;
import com.exercise.Events.CarrilCreado;
import com.exercise.Events.CarroAsignado;
import com.exercise.Events.KilometrajeCambiado;
import com.exercise.VO.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class MoverCarroEnCarrilTest  extends  UseCaseHandleBaseTest{
    @Test
    void moverCarroTest_happyPath() {

        var useCase = new MoverCarroUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CarrilCreado(NumeroCarril.of("101"), 6000),
                new CarroAsignado(CarroId.of("MX5124"),
                        new Conductor(
                                new Cedula("1001359866"),"Daniela Gaviria Mena",
                                new Informacion(20, "5 años")),
                        new TipoCarro("2015", "Dorado")
                )
        ));

        KilometrajeCambiado event = new KilometrajeCambiado("101");

        useCase.addRepository(repository);

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("101")
                .asyncExecutor(useCase, new TriggeredEvent<>(event))
                .subscribe(subscriber);

        //verify(subscriber).onNext(eventCaptor.capture());
        verify(subscriber, times(1)).onNext(eventCaptor.capture());
        KilometrajeCambiado kmc =  (KilometrajeCambiado)eventCaptor.getAllValues().get(0);
        Assertions.assertEquals("101", kmc.getNumeroCarril().value());

    }
}
