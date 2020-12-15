package com.exercise.useCase.services;

import com.exercise.useCase.model.CarroSobreCarril;
import com.exercise.videoJuego.values.CodigoJuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrilCarroQueryService implements CarrilCarroService{

    //@Autowired
    //private EventStoreRepository repository;

    @Override
    public List<CarroSobreCarril> getCarrosSobreCarriles(CodigoJuego codigoJuego) {
        return null;
    }
}
