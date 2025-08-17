package com.example.hoteleria.Utils;


import lombok.Getter;

@Getter
public enum Errores {

    HOTEL_NOTFOUND("Error_hotal", "no existe hotal"),
    INVALID_HOTEL("error_invalido_hotel", "Parametros invalidos para el hotel"),
    GENERIC_ERROR("ERROR_GENERICO", "Ocurrio un error inesperado");





    private final String codigo;

    private final String mensaje;


    Errores(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }
}
