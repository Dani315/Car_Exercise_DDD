package com.exercise.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.exercise.Command.AsignarCarroCommand;
import com.exercise.Conductor;
import com.exercise.Events.CarrilCreado;
import com.exercise.Events.CarroAsignado;
import com.exercise.VO.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AsignarCarroUseCaseTest  extends  UseCaseHandleBaseTest{

    @Test
    void asignarCarroTest_happyPath() {

        var useCase = new AsignarCarroUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CarrilCreado(NumeroCarril.of("101"), 6000)
        ));

        useCase.addRepository(repository);

        var request = new RequestCommand<>(new AsignarCarroCommand(
                NumeroCarril.of("101"),
                CarroId.of("MX5124"),
                new Conductor(new Cedula("1001359866"),"Daniela Gaviria Mena",
                        new Informacion(20, "5 años")),
                new TipoCarro("2015", "Dorado")
        ));

        System.out.println(request.getCommand().getNumeroCarril());

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("101")
                .asyncExecutor(useCase, request)
                .subscribe(subscriber);

        //verify(subscriber).onNext(eventCaptor.capture());
        verify(subscriber, times(1)).onNext(eventCaptor.capture());

        var carroAsignado = (CarroAsignado) eventCaptor.getAllValues().get(0);
        Assertions.assertEquals("MX5124", carroAsignado.getCarroId().value());
        Assertions.assertEquals(20, carroAsignado.getConductor().Informacion().value().edad());
    }

}