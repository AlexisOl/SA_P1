package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.DTOS;

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
    private HabitacionDTO habitacion;
    private UUID idusuario;
}
