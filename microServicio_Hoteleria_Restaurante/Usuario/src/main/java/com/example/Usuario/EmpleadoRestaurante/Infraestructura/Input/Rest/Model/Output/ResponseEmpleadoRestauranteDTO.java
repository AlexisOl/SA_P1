package com.example.Usuario.EmpleadoRestaurante.Infraestructura.Input.Rest.Model.Output;

import com.example.Usuario.EmpleadoHotel.Dominio.ObjetosValor.FechaTrabajo;
import com.example.Usuario.Persona.Dominio.Persona;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.UUID;

@Value
@Getter
@Setter
public class ResponseEmpleadoRestauranteDTO {
    private UUID id;
    private Persona persona;
    private UUID RestauranteId;
    private Double salario;
    private FechaTrabajo fecha;
    private Boolean estado;
}
