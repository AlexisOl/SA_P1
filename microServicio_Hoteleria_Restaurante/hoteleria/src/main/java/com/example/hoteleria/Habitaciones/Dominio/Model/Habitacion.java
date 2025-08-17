package com.example.hoteleria.Habitaciones.Dominio.Model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class Habitacion {

    private UUID id;
    private Long numero_habitacion;
    private Long cantidad_camas;

}
