package com.example.Promociones.promocionesRestaurante.Infraestrucura.Feigns.DTO;

import lombok.*;

import java.util.UUID;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HabitacionDTO {
    private UUID id;
    private Long numero_habitacion;
    private Long cantidad_camas;
    private RestauranteDTO hotel;
    private TipoPlatillo tipoHabitacion;
    private Double precio;
}
