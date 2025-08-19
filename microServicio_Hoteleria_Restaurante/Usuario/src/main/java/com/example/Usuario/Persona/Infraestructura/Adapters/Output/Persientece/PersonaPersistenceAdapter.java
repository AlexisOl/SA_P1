package com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece;

import com.example.Usuario.Persona.Aplicacion.Ports.output.BusquedaPersonaCuiOutputPersistencia;
import com.example.Usuario.Persona.Aplicacion.Ports.output.creacionPersonaOutputPersistenciaPuerto;
import com.example.Usuario.Persona.Dominio.Persona;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Mapper.PersonaPersistenceMapper;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Repository.PersonaRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PersonaPersistenceAdapter implements creacionPersonaOutputPersistenciaPuerto, BusquedaPersonaCuiOutputPersistencia {
    private  final PersonaRepository personaRepository;
    private final PersonaPersistenceMapper personaPersistenceMapper;


    @Override
    public Persona creacionPersona(Persona persona) {
     return this.personaPersistenceMapper.toPersona(
                     this.personaRepository.save(this.personaPersistenceMapper.toPersonaEntity(persona))
             );
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPersona(Long cui) {
        return Optional.ofNullable(this.personaPersistenceMapper.toPersona(
                this.personaRepository.findPersonaEntityByCui(cui)
        ));
    }
}
