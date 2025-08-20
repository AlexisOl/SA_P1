package com.example.hoteleria.Hotel.Dominio.Models;

import lombok.*;

import java.rmi.server.UID;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    private Long id;

    private String nombre;

    private String direccion;

    private Long telefono;


}
