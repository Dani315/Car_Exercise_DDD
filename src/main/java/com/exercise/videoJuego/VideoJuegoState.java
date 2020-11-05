package com.exercise.videoJuego;

import co.com.sofka.domain.generic.EventChange;
import com.exercise.videoJuego.events.*;
import com.exercise.videoJuego.values.Podium;

public class VideoJuegoState extends EventChange {
    public VideoJuegoState(VideoJuego videoJuego) {

        apply((VideoJuegoCreado event) -> {
            videoJuego.estado = false;
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
                videoJuego.podium = videoJuego.podium.asignarTercerLugar(event.getCarroGanador());
            } else {
                throw new IllegalArgumentException("No puede asignar al podium");
            }
        });

        apply((VideoJuegoFinalizado event) -> {
            videoJuego.estado = false;
        });

        apply((VideoJuegoEmpezado event) -> {
            videoJuego.estado = true;
        });
    }
}
