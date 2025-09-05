package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns.DTO;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlatillosResponseDTO {
    private UUID id;
    private String nombre;
    private Double precio;
    private TipoPlatillo tipo;
    private RestauranteReponseDTO idrestaurante;
}
