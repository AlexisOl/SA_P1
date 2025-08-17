package com.example.hoteleria.Hotel.Dominio.Exception.Error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorResponse {

    private String codigo;

    private String mensaje;

}
