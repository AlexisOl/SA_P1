package com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.Repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {
    Optional<UsuarioEntity> findByUsername(String username);
}
