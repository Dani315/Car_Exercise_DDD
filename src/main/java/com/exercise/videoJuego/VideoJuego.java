package com.exercise.videoJuego;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.pista.entities.Carril;
import com.exercise.pista.entities.Carro;
import com.exercise.videoJuego.events.*;
import com.exercise.videoJuego.values.CodigoJuego;
import com.exercise.videoJuego.values.Podium;

import java.util.List;

public class VideoJuego  extends AggregateEvent<CodigoJuego>  {
    protected Podium podium;
    protected boolean estado;

    public VideoJuego(CodigoJuego entityId, boolean estado) {
        super(entityId);
        appendChange(new VideoJuegoCreado()).apply();
    }

    private VideoJuego(CodigoJuego entityId) {
        super(entityId);
        subscribe(new VideoJuegoState(this));
    }

    public static VideoJuego from(CodigoJuego entityId, List<DomainEvent> events){
        var juego = new VideoJuego(entityId);
        events.forEach(juego::applyEvent);
        return juego;
    }

    public void asignarPrimerLugar(Carro carroGanador) {
        appendChange(new PrimerLugarAsignado(carroGanador)).apply();
    }

    public void asignarSegundoLugar(Carro carroGanador) {
        appendChange(new SegundoLugarAsignado(carroGanador)).apply();
    }

    public void asignarTercerLugar(Carro carroGanador) {
        appendChange(new TercerLugarAsignado(carroGanador)).apply();
    }

    public void finalizarVideoJuego() {
        appendChange(new VideoJuegoFinalizado()).apply();
    }

    public void empezarVideoJuego() {
        appendChange(new VideoJuegoEmpezado()).apply();
    }

    public Podium getPodium() {
        return podium;
    }

    public boolean isEstado() {
        return estado;
    }
}
