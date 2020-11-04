package com.exercise.Command;

import co.com.sofka.domain.generic.Command;
import com.exercise.Carro;
import com.exercise.VO.NumeroCarril;
import com.exercise.VO.TipoCarro;

public class CrearCarrilCommand implements Command {
    private NumeroCarril numeroCarril;
    private Integer limite;

    public CrearCarrilCommand(NumeroCarril numeroCarril, Integer limite) {
        this.numeroCarril = numeroCarril;
        this.limite = limite;
    }

    public CrearCarrilCommand() {
    }

    public NumeroCarril getNumeroCarril() {
        return numeroCarril;
    }

    public Integer getLimite() {
        return limite;
    }
}
