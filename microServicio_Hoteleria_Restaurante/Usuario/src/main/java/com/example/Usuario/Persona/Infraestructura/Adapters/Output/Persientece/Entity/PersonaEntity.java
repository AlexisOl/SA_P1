package com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persona")
public class PersonaEntity {
    @Id
    @Column(name = "cui", nullable = false, unique = true, length = 20)
    private Long cui;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String correo;
}
