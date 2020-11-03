package com.exercise.Command;

import co.com.sofka.domain.generic.Command;
import com.exercise.Conductor;
import com.exercise.VO.CarroId;
import com.exercise.VO.NumeroCarril;
import com.exercise.VO.TipoCarro;

public class AsignarCarroCommand implements Command {
    private CarroId carroId;
    private Conductor conductor;
    private TipoCarro tipoCarro;
    private NumeroCarril numeroCarril;

    public AsignarCarroCommand(NumeroCarril numeroCarril, CarroId carroId, Conductor conductor, TipoCarro tipoCarro) {
        this.carroId = carroId;
        this.conductor = conductor;
        this.tipoCarro = tipoCarro;
        this.numeroCarril = numeroCarril;
    }

    public AsignarCarroCommand() {
    }

    public CarroId getCarroId() {
        return carroId;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public NumeroCarril getNumeroCarril() {
        return numeroCarril;
    }
}
