package com.example.Usuario.EmpleadoHotel.Dominio.ObjetosValor;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FechaTrabajo {
    private LocalDate fecha;


    public FechaTrabajo(LocalDate fecha) {
        if (fecha == null || fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha no puede ser anterior a hoy");
        }
        this.fecha = fecha;
    }
    public static FechaTrabajo fromDatabase(LocalDate fecha) {
        FechaTrabajo f = new FechaTrabajo();
        f.fecha = fecha; // sin validación
        return f;
    }
    private FechaTrabajo() {}

    public LocalDate getFecha() {
        return fecha;
    }
}
