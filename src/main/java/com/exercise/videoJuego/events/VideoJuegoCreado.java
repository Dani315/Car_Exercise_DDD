package com.exercise.videoJuego.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.exercise.videoJuego.values.CodigoJuego;

public class VideoJuegoCreado extends DomainEvent {
    //private final boolean estado;
    //private final CodigoJuego codigoJuego;

    public VideoJuegoCreado() {
        super("com.exercise.videoJuego.VideoJuegoCreado");
        //this.estado = estado;
        //this.codigoJuego = null;
    }

    /*public VideoJuegoCreado() {
        super("com.exercise.videoJuego.VideoJuegoCreado");
        //this.estado = estado;
        //this.codigoJuego = codigoJuego;
    }
        public boolean isEstado() {
        return estado;
    }

    public CodigoJuego getCodigoJuego() {
        return codigoJuego;
    }
    */

}
