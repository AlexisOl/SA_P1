package com.example.Usuario.EmpleadoRestaurante.Dominio;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Empleado {
    private UUID id;
    private String persona;
    private Long idhotel;
    private Double salario;


    public Empleado(UUID id, String persona, Long idhotel, Double salario) {
        this.id = id;
        this.persona = persona;
        this.idhotel = idhotel;
        this.salario = salario;
    }
}
