package com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Entity;

import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Entity.PersonaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empleadoRestaurante")
public class EmpleadoRestauranteEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", referencedColumnName = "cui", nullable = false)
    private PersonaEntity persona;
    @Column(name = "RestauranteId", nullable = false)
    private UUID restauranteId;
    @Column(nullable = false)
    private double salario;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(nullable = false)
    private Boolean estado;

}
