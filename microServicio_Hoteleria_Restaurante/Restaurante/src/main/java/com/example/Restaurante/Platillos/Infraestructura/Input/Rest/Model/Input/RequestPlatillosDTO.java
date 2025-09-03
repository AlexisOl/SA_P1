package com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Model.Input;

import com.example.Restaurante.Platillos.Dominio.TipoPlatillo;
import lombok.Value;

import java.util.UUID;

@Value
public class RequestPlatillosDTO {
    private String nombre;
    private Double precio;
    private TipoPlatillo tipo;
    private UUID idrestaurante;
}
