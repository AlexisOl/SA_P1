package com.example.Usuario.clientes.Aplicacion.Service.CrearUsuario;


import com.example.Usuario.Persona.Dominio.Persona;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Entity.PersonaEntity;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Mapper.PersonaPersistenceMapper;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.PersonaPersistenceAdapter;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Repository.PersonaRepository;
import com.example.Usuario.clientes.Aplicacion.Ports.Input.CreacionUsuarioInputPort;
import com.example.Usuario.clientes.Aplicacion.Ports.Output.CreacionUsuarioOutputPersitencePort;
import com.example.Usuario.clientes.Dominio.Model.TipoEmpleado;
import com.example.Usuario.clientes.Dominio.Model.Usuario;
import com.example.Usuario.clientes.infraestructura.Adapters.Security.SecurityConfig;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class casoUsoCrearUsuario implements CreacionUsuarioInputPort {


    private final CreacionUsuarioOutputPersitencePort creacionUsuarioOutputPersitencePort;
    private final PersonaRepository personaRepository;
    private final PersonaPersistenceMapper personaPersistenceMapper;
    private final SecurityConfig securityConfig;

    @Override
    @Transactional
    public Usuario crearUsuario(crearUsuarioDTO usuarioDTO) {
        //busqueda de persona
       // Optional<Persona> nuevoPersonaOpt = (personaPersistenceAdapter.buscarPersona(usuarioDTO.getCui()));
        Persona nuevaPersona = new Persona(
                usuarioDTO.getCui(),
                usuarioDTO.getNombre(),
                usuarioDTO.getFechaNacimiento(),
                usuarioDTO.getDireccion(),
                usuarioDTO.getTelefono(),
                usuarioDTO.getCorreo()
        );

       // PersonaEntity persona = personaRepository.save(personaPersistenceMapper.toPersonaEntity(nuevaPersona));
        TipoEmpleado tipo = TipoEmpleado.valueOf("CLIENTE");
        if(!usuarioDTO.getTipoUsuario().isEmpty()){
            tipo =TipoEmpleado.valueOf("EMPLEADO");

        }
        //encriptar

            Usuario nuevoUsuario = creacionUsuarioOutputPersitencePort.crearUsuario(
                    new Usuario(UUID.randomUUID(),
                            usuarioDTO.getUsername(),
                            securityConfig.passwordEncoder().encode(usuarioDTO.getPassword()),
                            personaPersistenceMapper.toPersona(personaPersistenceMapper.toPersonaEntity(nuevaPersona)),
                            tipo
                    ));
            return nuevoUsuario;
        }
    }
