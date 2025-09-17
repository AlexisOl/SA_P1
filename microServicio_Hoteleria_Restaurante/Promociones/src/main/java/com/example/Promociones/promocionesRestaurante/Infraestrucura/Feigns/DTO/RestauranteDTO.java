package com.example.Promociones.promocionesRestaurante.Infraestrucura.Feigns.DTO;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteDTO {
    private UUID id;
    private String nombre;
    private String telefono;
    private String direccion;
    private Long idhotel;
}
