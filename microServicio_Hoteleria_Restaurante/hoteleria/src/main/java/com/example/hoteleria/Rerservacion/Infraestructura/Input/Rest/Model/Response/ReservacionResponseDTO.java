package com.example.hoteleria.Rerservacion.Infraestructura.Input.Rest.Model.Response;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Rerservacion.Dominio.TipoReservacion;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservacionResponseDTO {
    private UUID id;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Habitacion habitacion;
    private UUID idusuario;
    private TipoReservacion tipoReservacion;
}
