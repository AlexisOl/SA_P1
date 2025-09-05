package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns.DTO;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteReponseDTO {
    private UUID id;
    private String nombre;
    private String telefono;
    private String direccion;
    private Long idhotel;
}
