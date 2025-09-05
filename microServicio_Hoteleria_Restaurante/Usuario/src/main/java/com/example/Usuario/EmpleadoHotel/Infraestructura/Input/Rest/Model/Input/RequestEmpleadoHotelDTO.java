package com.example.Usuario.EmpleadoHotel.Infraestructura.Input.Rest.Model.Input;

import com.example.Usuario.EmpleadoHotel.Dominio.ObjetosValor.FechaTrabajo;
import com.example.Usuario.Persona.Dominio.Persona;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestEmpleadoHotelDTO {
    private Persona persona;
    private Long idhotel;
    private Double salario;
    private FechaTrabajo fecha;
}
