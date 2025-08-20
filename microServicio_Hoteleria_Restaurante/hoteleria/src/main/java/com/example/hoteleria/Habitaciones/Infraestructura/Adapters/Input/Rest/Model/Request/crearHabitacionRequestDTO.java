package com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Request;


import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class crearHabitacionRequestDTO {
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private Long numero_habitacion;
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private Long cantidad_camas;
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private Long id_hotel;

}
