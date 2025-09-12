package com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Model.Output;

import com.example.Restaurante.Platillos.Dominio.TipoPlatillo;
import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import java.util.UUID;
@Getter
@Setter
@Value
public class ResponsePlatillosDTO {
    private UUID id;
    private String nombre;
    private Double precio;
    private TipoPlatillo tipo;
    private Restaurante idrestaurante;
    private Double promedio_valoracion;
}
