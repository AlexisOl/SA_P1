package com.example.Restaurante.Platillos.Aplicacion.Service.CasoUsoCrearPlatillo;

import com.example.Restaurante.Platillos.Dominio.TipoPlatillo;
import lombok.Value;

import java.util.UUID;


@Value
public class CrearPlatilloDTO {
    private UUID id;
    private String nombre;
    private Double precio;
    private TipoPlatillo tipo;
    private UUID restaurante;
}
