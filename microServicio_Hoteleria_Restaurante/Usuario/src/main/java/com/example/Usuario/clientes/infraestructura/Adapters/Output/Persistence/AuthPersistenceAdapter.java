package com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence;

import com.example.Usuario.clientes.Aplicacion.Ports.Output.AuthOutputPort;
import com.example.Usuario.clientes.Dominio.Model.Usuario;
import com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.Mapper.UsuarioPersistenceMapper;
import com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.Repository.UsuarioRepository;
import org.springframework.stereotype.Component;

@Component
public class AuthPersistenceAdapter implements AuthOutputPort {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioPersistenceMapper usuarioPersistenceMapper;

    public AuthPersistenceAdapter(UsuarioRepository usuarioRepository,
                                  UsuarioPersistenceMapper usuarioPersistenceMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioPersistenceMapper = usuarioPersistenceMapper;
    }

    @Override
    public Usuario buscarUsuarioPorUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .map(usuarioPersistenceMapper::toPUssuario)
                .orElse(null);
    }
}
