package com.exercise.videoJuego.values;

import co.com.sofka.domain.generic.ValueObject;
import com.exercise.pista.entities.Carro;

public class Podium implements ValueObject<Podium.Props> {
    private final Carro primerLugar;
    private final Carro segundoLugar;
    private final Carro tercerLugar;

    private Podium(Carro primerLugar, Carro segundoLugar, Carro tercerLugar) {
        this.primerLugar = primerLugar;
        this.segundoLugar = segundoLugar;
        this.tercerLugar = tercerLugar;
    }

    public Podium() {
        primerLugar = null;
        segundoLugar = null;
        tercerLugar = null;
    }

    public Podium asignarPrimerLugar(Carro jugador) {
        return new Podium(jugador, segundoLugar, tercerLugar);
    }

    public Podium asignarSegundoLugar(Carro jugador) {
        return new Podium(primerLugar, jugador, tercerLugar);
    }

    public Podium asignarTercerLugar(Carro jugador) {
        return new Podium(primerLugar, segundoLugar, jugador);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Carro primerLugar() {
                return primerLugar;
            }

            @Override
            public Carro segundoLugar() {
                return segundoLugar;
            }

            @Override
            public Carro tercerLugar() {
                return tercerLugar;
            }
        };
    }

    public interface Props {
        Carro primerLugar();

        Carro segundoLugar();

        Carro tercerLugar();
    }

    public boolean isPodiumDisponible() {
        return primerLugar == null ||
                segundoLugar == null  ||
                tercerLugar == null;
    }
}
