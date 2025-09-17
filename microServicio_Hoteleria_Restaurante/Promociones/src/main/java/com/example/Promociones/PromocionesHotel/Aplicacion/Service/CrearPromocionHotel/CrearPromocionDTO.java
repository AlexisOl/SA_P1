package com.example.Promociones.PromocionesHotel.Aplicacion.Service.CrearPromocionHotel;

import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class CrearPromocionDTO {
    private int cantidad_descuento;
    private LocalDate fecha_inicio;
    private LocalDate fecha_final;
    private UUID habitacion;
}
