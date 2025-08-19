package com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.Repository;

import com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {
}
