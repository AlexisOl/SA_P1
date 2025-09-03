package com.example.Restaurante.Restaurante.Aplicacion.Service.CasoUsoCreacionRestaurante;

import lombok.Value;

import java.util.UUID;

@Value
public class CreacionRestauranteDTO {
    private String nombre;
    private String telefono;
    private String direccion;
    private Long idhotel;
}
