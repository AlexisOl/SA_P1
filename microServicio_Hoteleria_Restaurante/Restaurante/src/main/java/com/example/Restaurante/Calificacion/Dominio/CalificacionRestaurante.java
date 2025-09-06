package com.example.Restaurante.Calificacion.Dominio;


import com.example.Restaurante.Platillos.Dominio.Platillos;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CalificacionRestaurante {

    private UUID id;
    private String comentario;
    private Double puntuacion;
    private Platillos platillo;


    public CalificacionRestaurante(UUID id, String comentario, Double puntuacion, Platillos platillo) {
        this.id = id;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.platillo  = platillo;
    }

}
