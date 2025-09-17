package com.example.Promociones.promocionesRestaurante.Dominio;

import lombok.Getter;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Value
public class PromocionRestaurante {
    private UUID id;
    private int cantidad_descuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private UUID platillo;
}
