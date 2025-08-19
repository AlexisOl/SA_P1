package com.example.Usuario.clientes.Aplicacion.Service.CrearUsuario;


import com.example.Usuario.Persona.Dominio.Persona;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Mapper.PersonaPersistenceMapper;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.PersonaPersistenceAdapter;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Repository.PersonaRepository;
import com.example.Usuario.clientes.Aplicacion.Ports.Input.CreacionUsuarioInputPort;
import com.example.Usuario.clientes.Aplicacion.Ports.Output.CreacionUsuarioOutputPersitencePort;
import com.example.Usuario.clientes.Dominio.Model.Usuario;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class casoUsoCrearUsuario implements CreacionUsuarioInputPort {


    private final CreacionUsuarioOutputPersitencePort creacionUsuarioOutputPersitencePort;
    private final PersonaPersistenceAdapter personaPersistenceAdapter;
    private final PersonaPersistenceMapper personaPersistenceMapper;

    @Override
    @Transactional
    public Usuario crearUsuario(crearUsuarioDTO usuarioDTO) {
        //busqueda de persona
        Optional<Persona> nuevoPersonaOpt = (personaPersistenceAdapter.buscarPersona(usuarioDTO.getCui()));

        if (nuevoPersonaOpt.isPresent()) {
            Persona nuevoPersona = nuevoPersonaOpt.get();
            Usuario nuevoUsuario = creacionUsuarioOutputPersitencePort.crearUsuario(
                    new Usuario(UUID.randomUUID(),
                            usuarioDTO.getUsername(),
                            usuarioDTO.getPassword(),
                            nuevoPersona)
            );
            return nuevoUsuario;
        }
        return null;
    }
}
