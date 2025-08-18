package com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Mapper;

import com.example.Usuario.Persona.Dominio.Persona;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Entity.PersonaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaPersistenceMapper {

    PersonaEntity toPersonaEntity(Persona persona);
    Persona toPersona(PersonaEntity personaEntity);
    List<Persona> toPersonaEntityList(List<PersonaEntity> personas);

}
