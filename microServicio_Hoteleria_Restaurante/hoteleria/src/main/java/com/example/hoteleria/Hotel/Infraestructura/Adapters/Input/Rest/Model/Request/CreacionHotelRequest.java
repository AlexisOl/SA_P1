package com.example.hoteleria.Hotel.Infraestructura.Adapters.Input.Rest.Model.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreacionHotelRequest {


    // ver si se usa en el obketo de dominio
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private String nombre;
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private String direccion;
    @NotNull(message = "No pueden haber campos vacios ni nulos")
    private Long telefono;
}
