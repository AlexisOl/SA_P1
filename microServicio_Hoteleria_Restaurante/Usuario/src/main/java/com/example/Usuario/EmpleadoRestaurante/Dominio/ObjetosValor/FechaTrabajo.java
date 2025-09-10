package com.example.Usuario.EmpleadoRestaurante.Dominio.ObjetosValor;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FechaTrabajo {
    private LocalDate fecha;


    public FechaTrabajo(LocalDate fecha) {
        if (fecha == null || !fecha.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException();
        }
        this.fecha = fecha;
    }
}
