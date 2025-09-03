package com.example.Restaurante.Platillos.Dominio;

import com.example.Restaurante.Restaurante.Dominio.Restaurante;

import java.util.UUID;


public class Platillos {
    private UUID id;
    private String nombre;
    private Double precio;
    private TipoPlatillo  tipo;
    private Restaurante restaurante;


    public Platillos(UUID id, String nombre, Double precio, TipoPlatillo tipo, Restaurante restaurante) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.restaurante = restaurante;
    }

}
