package com.exercise.videoJuego;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.pista.entities.Carro;
import com.exercise.pista.events.PrimerLugarAsignado;
import com.exercise.pista.events.SegundoLugarAsignado;
import com.exercise.pista.events.TercerLugarAsignado;
import com.exercise.videoJuego.events.VideoJuegoCreado;
import com.exercise.videoJuego.values.CodigoJuego;
import com.exercise.videoJuego.values.Podium;

import java.util.List;

public class VideoJuego  extends AggregateEvent<CodigoJuego>  {
    protected Podium podium;
    protected boolean estado;

    public VideoJuego(CodigoJuego entityId, boolean estado) {
        super(entityId);
        appendChange(new VideoJuegoCreado(estado)).apply();
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

    public void asignarAPodium(Carro carroGanador) {

        if(podium.value().primerLugar() != null) {
            appendChange(new PrimerLugarAsignado(carroGanador)).apply();
        }else if (podium.value().segundoLugar() != null) {
            appendChange(new SegundoLugarAsignado(carroGanador)).apply();
        }else if (podium.value().tercerLugar() != null) {
            appendChange(new TercerLugarAsignado(carroGanador)).apply();
        }else {
            throw new IllegalArgumentException("No puede asignar al podio");
        }
    }
}
