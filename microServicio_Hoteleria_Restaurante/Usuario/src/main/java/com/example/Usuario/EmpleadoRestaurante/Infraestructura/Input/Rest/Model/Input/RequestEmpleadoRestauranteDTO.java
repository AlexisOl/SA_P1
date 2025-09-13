package com.example.Usuario.EmpleadoRestaurante.Infraestructura.Input.Rest.Model.Input;

import com.example.Usuario.EmpleadoHotel.Dominio.ObjetosValor.FechaTrabajo;
import com.example.Usuario.Persona.Dominio.Persona;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
@Getter
@Setter
public class RequestEmpleadoRestauranteDTO {
    private Persona persona;
    private Long RestauranteId;
    private Double salario;
    private FechaTrabajo fecha;
}
