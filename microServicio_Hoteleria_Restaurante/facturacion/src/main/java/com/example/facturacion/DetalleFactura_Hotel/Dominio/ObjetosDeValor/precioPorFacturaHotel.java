package com.example.facturacion.DetalleFactura_Hotel.Dominio.ObjetosDeValor;

import lombok.Value;

import java.time.LocalDate;

@Value
public class precioPorFacturaHotel {

    private final double precio;

    public precioPorFacturaHotel(double precioHabitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
        long noches = java.time.temporal.ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
        if (noches <= 0) {
            throw new IllegalArgumentException("La reservación debe tener al menos 1 noche");
        }
        this.precio = precioHabitacion * noches;
    }
}
