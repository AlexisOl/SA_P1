package com.example.hoteleria.Rerservacion.Infraestructura.Input.Rest.Model.Request;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservacionRequestDTO {
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private UUID id_habitacion;
    private UUID idusuario;
}
