package com.example.Restaurante.Platillos.Dominio;

import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Platillos {
    private UUID id;
    private String nombre;
    private Double precio;
    private TipoPlatillo  tipo;
    private Restaurante idrestaurante;


    public Platillos(UUID id, String nombre, Double precio, TipoPlatillo tipo, Restaurante idrestaurante) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.idrestaurante = idrestaurante;
    }

}
