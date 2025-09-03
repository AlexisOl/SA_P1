package com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Model.Output;

import com.example.Restaurante.Platillos.Dominio.TipoPlatillo;
import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import lombok.Value;

import java.util.UUID;

@Value
public class ResponsePlatillosDTO {
    private UUID id;
    private String nombre;
    private Double precio;
    private TipoPlatillo tipo;
    private Restaurante idrestaurante;
}
