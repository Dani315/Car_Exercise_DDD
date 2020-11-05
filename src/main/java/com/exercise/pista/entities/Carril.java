package com.exercise.pista.entities;

import co.com.sofka.domain.generic.Entity;
import com.exercise.pista.values.NumeroCarril;

public class Carril extends Entity<NumeroCarril> {
    protected Carro carro;
    protected Integer limite;

    public Carril(NumeroCarril entityId, Integer limite) {
        super(entityId);
        this.carro = null;
        this.limite = limite;
    }

    public Carril(NumeroCarril entityId, Carro carro,Integer limite) {
        super(entityId);
        this.carro = carro;
        this.limite = limite;
    }

    public Carro Carro() {
        return carro;
    }

    public Integer Limite() {
        return limite;
    }

    public void asignarCarro(Carro carro) {
        this.carro = carro;
    }
}
