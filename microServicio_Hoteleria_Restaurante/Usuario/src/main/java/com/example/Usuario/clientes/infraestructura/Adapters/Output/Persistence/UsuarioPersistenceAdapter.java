package com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence;

import com.example.Usuario.Persona.Dominio.Persona;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Mapper.PersonaPersistenceMapper;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Repository.PersonaRepository;
import com.example.Usuario.clientes.Aplicacion.Ports.Input.CreacionUsuarioInputPort;
import com.example.Usuario.clientes.Aplicacion.Ports.Output.CreacionUsuarioOutputPersitencePort;
import com.example.Usuario.clientes.Aplicacion.Ports.Output.LoginOutputPort;
import com.example.Usuario.clientes.Aplicacion.Service.CrearUsuario.crearUsuarioDTO;
import com.example.Usuario.clientes.Dominio.Model.Usuario;
import com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.Mapper.UsuarioPersistenceMapper;
import com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.Repository.UsuarioRepository;
import com.example.Usuario.clientes.infraestructura.Adapters.Security.JWTServicio;
import com.example.Usuario.clientes.infraestructura.Adapters.Security.SecurityConfig;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioPersistenceAdapter implements CreacionUsuarioOutputPersitencePort, LoginOutputPort {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioPersistenceMapper usuarioPersistenceMapper;
    private final PersonaPersistenceMapper personaPersistenceMapper;
    private final PersonaRepository personaRepository;
    private final JWTServicio jwtServicio;
    private final SecurityConfig securityConfig;



    @Override
    @Transactional
    public Usuario crearUsuario(Usuario usuario) {

        Persona nuevaPersona = personaPersistenceMapper.toPersona(
                this.personaRepository.save(personaPersistenceMapper.toPersonaEntity(usuario.getPersona())));

        return usuarioPersistenceMapper.toPUssuario(
                usuarioRepository.save(
                        usuarioPersistenceMapper.toUsuarioEntity(usuario)
                )
        );
    }

    @Override
    public String login(Usuario loginUsuarioDTO) {
        Usuario usuario = usuarioRepository.findByUsername(loginUsuarioDTO.getUsername())
                .map(usuarioPersistenceMapper::toPUssuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));


//        if (!securityConfig.passwordEncoder().matches(loginUsuarioDTO.getPassword(), usuario.getPassword())) {
//            throw new RuntimeException("Contraseña incorrecta");
//        }
        if (!(loginUsuarioDTO.getPassword().equals(usuario.getPassword()) )) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        System.out.println(usuario.getTipoEmpleado()+ "--"+ usuario.getUsername());
        String token = jwtServicio.obtenerToken(usuario);

        return token;
    }
}
