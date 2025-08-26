package com.example.hoteleria.Rerservacion.Dominio;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Reservacion {
    private UUID id;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Habitacion habitacion;
    private TipoReservacion tipoReservacion;
    private UUID id_usuario;

    public Reservacion(UUID id, LocalDate fechaEntrada, LocalDate fechaSalida, Habitacion habitacion, UUID id_usuario, TipoReservacion tipoReservacion) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.habitacion = habitacion;
        this.id_usuario = id_usuario;
        this.tipoReservacion = tipoReservacion;
    }


    // validaciones
}
