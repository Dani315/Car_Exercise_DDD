package com.exercise;

import co.com.sofka.domain.generic.Entity;
import com.exercise.VO.Cedula;
import com.exercise.VO.Informacion;

import java.util.Random;

public class Conductor extends Entity<Cedula> {
    protected String nombreCompleto;
    protected Informacion informacion;

    public Conductor(Cedula entityId, String nombreCompleto, Informacion informacion) {
        super(entityId);
        this.nombreCompleto = nombreCompleto;
        this.informacion = informacion;
    }

    public String NombreCompleto() {
        return nombreCompleto;
    }

    public Informacion Informacion() {
        return informacion;
    }

    public int lanzarDado() {
        Random random =  new Random();
        return random.nextInt(6) + 1;
    }
}
