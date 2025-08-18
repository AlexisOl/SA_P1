package com.example.Usuario.Persona.Infraestructura.Adapters.Input.Rest.Model.Response;

import lombok.*;

import java.time.LocalDate;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaResponse {
    private Long cui;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String correo;
}
