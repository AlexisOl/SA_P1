package com.example.Promociones.promocionesRestaurante.Infraestrucura.Feigns.DTO;

import lombok.*;

import java.util.UUID;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuscarPlatilloResponseDTO {
    private UUID id;
    private String nombre;
    private Double precio;
    private TipoPlatillo tipo;
    private RestauranteDTO idrestaurante;
    private Double promedio_valoracion;
}
