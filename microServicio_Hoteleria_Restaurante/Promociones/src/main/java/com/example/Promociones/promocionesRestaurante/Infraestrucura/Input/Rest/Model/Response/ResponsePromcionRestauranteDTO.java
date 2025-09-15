package com.example.Promociones.promocionesRestaurante.Infraestrucura.Input.Rest.Model.Response;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePromcionRestauranteDTO {
    private UUID id;
    private int cantidad_descuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private UUID platillo;
}
