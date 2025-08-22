package com.example.Usuario.clientes.Aplicacion.Service.CrearUsuario;


import com.example.Usuario.Persona.Dominio.Persona;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
@AllArgsConstructor
public class crearUsuarioDTO {

    @NotBlank
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Long cui;
    @NotBlank
    private String nombre;
    @NotNull
    private LocalDate fechaNacimiento;
    @NotBlank
    private String direccion;
    @NotNull
    private String telefono;
    @Email
    private String correo;

    // para el dominio
    public Persona toDomainPersona() {
        return new Persona(cui, nombre, fechaNacimiento, direccion, telefono, correo);
    }
}
