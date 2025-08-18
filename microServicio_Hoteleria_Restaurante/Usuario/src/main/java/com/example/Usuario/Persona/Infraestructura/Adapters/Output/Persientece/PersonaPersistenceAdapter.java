package com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece;

import com.example.Usuario.Persona.Aplicacion.Ports.output.creacionPersonaOutputPersistenciaPuerto;
import com.example.Usuario.Persona.Dominio.Persona;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Mapper.PersonaPersistenceMapper;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Repository.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PersonaPersistenceAdapter implements creacionPersonaOutputPersistenciaPuerto {
    private  final PersonaRepository personaRepository;
    private final PersonaPersistenceMapper personaPersistenceMapper;


    @Override
    public Persona creacionPersona(Persona persona) {
     return this.personaPersistenceMapper.toPersona(
                     this.personaRepository.save(this.personaPersistenceMapper.toPersonaEntity(persona))
             );
    }
}
