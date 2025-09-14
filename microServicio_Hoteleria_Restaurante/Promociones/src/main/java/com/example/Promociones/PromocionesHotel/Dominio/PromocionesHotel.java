package com.example.Promociones.PromocionesHotel.Dominio;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class PromocionesHotel {
    private UUID id;
    private int cantidad_descuento;
    private LocalDate fecha_inicio;
    private LocalDate fecha_final;
    private UUID habitacion;
}
