package com.example.hoteleria.Rerservacion.Dominio;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Reservacion {
    private UUID id;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Habitacion habitacion;
    private UUID id_usuario;


    // validaciones
}
