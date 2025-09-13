package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Service.CrearEmpleadoRestaurante;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class CrearEmpleadoRestauranteDTO {
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
    @NotNull
    private UUID restauranteId;
    @NotNull
    private Double salario;
    @NotNull
    private LocalDate fecha;
    @NotBlank
    private String username;
    @NotNull
    private String password;
}
