package com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.Entity;

import com.example.Usuario.Persona.Dominio.Persona;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Entity.PersonaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @Column(name = "id", nullable = false, unique = true, length = 20)
    private UUID id;
    private String username;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", referencedColumnName = "cui", nullable = false)
    private PersonaEntity persona;
}
