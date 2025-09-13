package com.example.Usuario.EmpleadoHotel.Dominio;

import com.example.Usuario.EmpleadoHotel.Dominio.ObjetosValor.FechaTrabajo;
import com.example.Usuario.Persona.Dominio.Persona;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class EmpleadoHotel {
    private UUID id;
    private Persona persona;
    private Long idhotel;
    private Double salario;
    private FechaTrabajo fecha;
    private Boolean estado;


    public EmpleadoHotel(UUID id, Persona persona, Long idhotel, Double salario, FechaTrabajo fecha) {
        this.id = id;
        this.persona = persona;
        this.idhotel = idhotel;
        this.salario = salario;
        this.fecha = fecha;
        this.estado = true;
    }
}
