package com.example.Restaurante.Restaurante.Infraestructura.Input.Rest.Model.Output;

import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseRestauranteDTO {

    private UUID id;
    private String nombre;
    private String telefono;
    private String direccion;
    private Long idhotel;
}
