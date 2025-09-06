package com.example.Restaurante.Calificacion.Aplicacion.Service.CrearCalificacion;

import com.example.Restaurante.Platillos.Dominio.Platillos;
import lombok.Value;

import java.util.UUID;

@Value
public class CrearCalificacionRestauranteDTO {
    private String comentario;
    private Double puntuacion;
    private UUID platillo;
}
