package com.example.hoteleria.Calificacion.Dominio;

public enum Puntuacion {
    EXCELENTE(5),
    MUY_BUENO(4),
    BUENO(3),
    REGULAR(2),
    MALO(1);


    private final int valor;

    Puntuacion(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

}
