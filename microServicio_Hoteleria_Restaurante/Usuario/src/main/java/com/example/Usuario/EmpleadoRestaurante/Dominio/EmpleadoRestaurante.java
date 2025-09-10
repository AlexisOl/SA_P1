package com.example.Usuario.EmpleadoRestaurante.Dominio;

import com.example.Usuario.EmpleadoRestaurante.Dominio.ObjetosValor.FechaTrabajo;
import com.example.Usuario.Persona.Dominio.Persona;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EmpleadoRestaurante {
    private UUID id;
    private Persona persona;
    private UUID RestauranteId;
    private Double salario;
    private FechaTrabajo fecha;
    private Boolean estado;


    public EmpleadoRestaurante(UUID id, Persona persona, UUID RestauranteId, Double salario, FechaTrabajo fecha) {
        this.id = id;
        this.persona = persona;
        this.RestauranteId = RestauranteId;
        this.salario = salario;
        this.fecha = fecha;
        this.estado = true;
    }
}
