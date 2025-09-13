package com.example.hoteleria.Rerservacion.Aplicacion.Service.CasosUso.CrearReservacion;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Rerservacion.Dominio.TipoReservacion;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;
@Value
@Getter
@Setter
public class CrearReservacionDTO {

    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private UUID habitacion;
    private String tipoReservacion;
    private UUID idusuario;
}
