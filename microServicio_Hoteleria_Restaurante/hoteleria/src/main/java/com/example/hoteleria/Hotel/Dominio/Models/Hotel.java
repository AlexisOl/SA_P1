package com.example.hoteleria.Hotel.Dominio.Models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.rmi.server.UID;
@Getter
@Setter
@Builder
public class Hotel {

    private Long id;

    private String nombre;

    private String direccion;

    private Long telefono;


}
