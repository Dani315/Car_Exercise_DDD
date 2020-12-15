package com.exercise.useCase.services;

import com.exercise.useCase.model.CarroSobreCarril;
import com.exercise.videoJuego.values.CodigoJuego;

import java.util.List;

public interface CarrilCarroService {
    List<CarroSobreCarril> getCarrosSobreCarriles(CodigoJuego codigoJuego);
}
