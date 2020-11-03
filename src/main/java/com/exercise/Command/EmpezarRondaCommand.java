package com.exercise.Command;

import co.com.sofka.domain.generic.Command;
import com.exercise.Carril;

import java.util.List;

public class EmpezarRondaCommand implements Command {
    private List<Carril> carrilList;
    private Integer cantidadCarriles;

    public EmpezarRondaCommand(List<Carril> carrilList, Integer cantidadCarriles) {
        this.carrilList = carrilList;
        this.cantidadCarriles = cantidadCarriles;
    }

    public EmpezarRondaCommand() {

    }

    public List<Carril> getCarrilList() {
        return carrilList;
    }

    public Integer getCantidadCarriles() {
        return cantidadCarriles;
    }
}
