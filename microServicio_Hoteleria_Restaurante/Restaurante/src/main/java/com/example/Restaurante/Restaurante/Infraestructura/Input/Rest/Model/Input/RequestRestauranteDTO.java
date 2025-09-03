package com.example.Restaurante.Restaurante.Infraestructura.Input.Rest.Model.Input;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestRestauranteDTO {
    private String nombre;
    private String telefono;
    private String direccion;
    private Long idhotel;
}
