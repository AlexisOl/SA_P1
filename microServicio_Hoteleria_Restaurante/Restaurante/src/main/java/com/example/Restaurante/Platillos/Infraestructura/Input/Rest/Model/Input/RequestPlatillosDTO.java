package com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Model.Input;

import com.example.Restaurante.Platillos.Dominio.TipoPlatillo;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.UUID;

@Getter
@Setter
@Value
public class RequestPlatillosDTO {
    private String nombre;
    private Double precio;
    private TipoPlatillo tipo;
    private UUID idrestaurante;
    private Double promedio_valoracion;
}
