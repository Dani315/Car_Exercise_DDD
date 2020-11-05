package com.exercise.videoJuego;

import co.com.sofka.domain.generic.EventChange;
import com.exercise.videoJuego.events.PrimerLugarAsignado;
import com.exercise.videoJuego.events.SegundoLugarAsignado;
import com.exercise.videoJuego.events.TercerLugarAsignado;
import com.exercise.videoJuego.events.VideoJuegoCreado;
import com.exercise.videoJuego.values.Podium;

public class VideoJuegoState extends EventChange {
    public VideoJuegoState(VideoJuego videoJuego) {

        apply((VideoJuegoCreado event) -> {
            videoJuego.estado = event.isEstado();
            videoJuego.podium = new Podium();
        });

        apply((PrimerLugarAsignado event) -> {
            if (videoJuego.estado && videoJuego.podium.isPodiumDisponible()) {
                videoJuego.podium = videoJuego.podium.asignarPrimerLugar(event.getCarroGanador());
            } else {
                throw new IllegalArgumentException("No puede asignar al podium");
            }
        });
        apply((SegundoLugarAsignado event) -> {
            if (videoJuego.estado && videoJuego.podium.isPodiumDisponible()) {
                videoJuego.podium = videoJuego.podium.asignarSegundoLugar(event.getCarroGanador());
            } else {
                throw new IllegalArgumentException("No puede asignar al podium");
            }
        });
        apply((TercerLugarAsignado event) -> {
            if (videoJuego.estado && videoJuego.podium.isPodiumDisponible()) {
                videoJuego.podium = videoJuego.podium.asignarSegundoLugar(event.getCarroGanador());
            } else {
                throw new IllegalArgumentException("No puede asignar al podium");
            }
        });
    }
}
