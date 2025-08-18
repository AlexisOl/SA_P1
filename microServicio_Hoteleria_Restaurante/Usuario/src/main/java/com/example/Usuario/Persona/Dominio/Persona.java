package com.example.Usuario.Persona.Dominio;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    private Long cui;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String correo;
}
