package com.example.Usuario.EmpleadoHotel.Infraestructura.Output.Entity;

import com.example.Usuario.EmpleadoHotel.Dominio.ObjetosValor.FechaTrabajo;
import com.example.Usuario.Persona.Dominio.Persona;
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
@Table(name = "empleadoHotel")
public class EmpleadoHotelEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", referencedColumnName = "cui", nullable = false)
    private PersonaEntity persona;
    @Column(name = "idhotel", nullable = false)
    private Long idhotel;
    @Column(nullable = false)
    private double salario;
    @Column(nullable = false)
    private LocalDate fecha;


}
