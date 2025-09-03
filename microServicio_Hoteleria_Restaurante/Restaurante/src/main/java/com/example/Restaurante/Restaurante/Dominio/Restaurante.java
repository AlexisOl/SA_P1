package com.example.Restaurante.Restaurante.Dominio;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Restaurante {

    private UUID id;
    private String nombre;
    private String telefono;
    private String direccion;
    // aca si puede estar dentro de un hotel
    private Long idhotel;

    public Restaurante(UUID id, String nombre, String telefono, String direccion, Long idhotel) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.idhotel = idhotel;
    }

}
