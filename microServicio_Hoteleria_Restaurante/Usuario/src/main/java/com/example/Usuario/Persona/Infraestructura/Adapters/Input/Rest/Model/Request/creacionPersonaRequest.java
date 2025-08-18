package com.example.Usuario.Persona.Infraestructura.Adapters.Input.Rest.Model.Request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class creacionPersonaRequest {
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private String cui;
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private String nombre;
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private LocalDate fechaNacimiento;
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private String direccion;
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private String telefono;
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private String correo;

}
