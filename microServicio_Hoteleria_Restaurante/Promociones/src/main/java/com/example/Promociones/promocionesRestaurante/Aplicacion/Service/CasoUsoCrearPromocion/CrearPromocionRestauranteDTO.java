package com.example.Promociones.promocionesRestaurante.Aplicacion.Service.CasoUsoCrearPromocion;

import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class CrearPromocionRestauranteDTO {
    private int cantidad_descuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private UUID platillo;
}
