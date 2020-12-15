package com.exercise.useCase.model;

public  class CarroSobreCarril {
    private String placa;
    private String numeroCarril;


    public CarroSobreCarril(){}

    public CarroSobreCarril(String placa, String numeroCarril) {
        this.placa = placa;
        this.numeroCarril = numeroCarril;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNumeroCarril() {
        return numeroCarril;
    }

    public void setNumeroCarril(String numeroCarril) {
        this.numeroCarril = numeroCarril;
    }

    @Override
    public String toString() {
        return "CarroSobreCarril{" +
                "carroId='" + placa + '\'' +
                ", carrilId='" + numeroCarril + '\'' +
                '}';
    }
}
