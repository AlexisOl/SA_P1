package com.example.Usuario.EmpleadoHotel.Aplicacion.Service.CrearEmpleadoHotel;

import com.example.Usuario.EmpleadoHotel.Dominio.ObjetosValor.FechaTrabajo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;

@Value
public class CrearEmpleadoDTO {

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

    private Long idhotel;
    @NotNull

    private Double salario;
    @NotNull

    private LocalDate fecha;

}
