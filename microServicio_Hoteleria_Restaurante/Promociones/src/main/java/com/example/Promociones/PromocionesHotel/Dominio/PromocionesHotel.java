package com.example.Promociones.PromocionesHotel.Dominio;

import lombok.Getter;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Value
public class PromocionesHotel {
    private UUID id;
    private int cantidad_descuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private UUID habitacion;
}
