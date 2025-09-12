package com.example.Restaurante.Calificacion.Infraestructura.Input.Rest.Model.Output;

import com.example.Restaurante.Platillos.Dominio.Platillos;
import lombok.Value;

import java.util.UUID;
@Value
public class ResponseCalificacionPlatilloDTO {
    private UUID id;
    private String comentario;
    private Double puntuacion;
    private Platillos platillo;
}
