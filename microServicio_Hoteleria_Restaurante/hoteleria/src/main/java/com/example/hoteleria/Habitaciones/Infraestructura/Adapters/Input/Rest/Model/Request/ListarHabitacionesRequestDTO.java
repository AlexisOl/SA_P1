package com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListarHabitacionesRequestDTO {
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private Long numero_habitacion;
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private Long cantidad_camas;
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private Long id_hotel;
}
