package com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence;

import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Mapper.PersonaPersistenceMapper;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Repository.PersonaRepository;
import com.example.Usuario.clientes.Aplicacion.Ports.Input.CreacionUsuarioInputPort;
import com.example.Usuario.clientes.Aplicacion.Ports.Output.CreacionUsuarioOutputPersitencePort;
import com.example.Usuario.clientes.Aplicacion.Service.CrearUsuario.crearUsuarioDTO;
import com.example.Usuario.clientes.Dominio.Model.Usuario;
import com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.Mapper.UsuarioPersistenceMapper;
import com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioPersistenceAdapter implements CreacionUsuarioOutputPersitencePort {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioPersistenceMapper usuarioPersistenceMapper;



    @Override
    @Transactional
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioPersistenceMapper.toPUssuario(
                usuarioRepository.save(
                        usuarioPersistenceMapper.toUsuarioEntity(usuario)
                )
        );
    }
}
