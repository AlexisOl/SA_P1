package com.example.Usuario.EmpleadoRestaurante.Dominio.ObjetosValor;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FechaTrabajo {
    private LocalDate fecha;



    public FechaTrabajo(LocalDate fecha) {
        if (fecha == null ) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        this.fecha = fecha;
    }
    public static FechaTrabajo fromDatabase(LocalDate fecha) {
       FechaTrabajo f = new FechaTrabajo();
        f.fecha = fecha; // sin validación
        return f;
    }
    private FechaTrabajo() {}

}
