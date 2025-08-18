package com.example.Usuario.Persona.Infraestructura.Adapters.Input.Rest.Mapper;

import com.example.Usuario.Persona.Dominio.Persona;
import com.example.Usuario.Persona.Infraestructura.Adapters.Input.Rest.Model.Request.creacionPersonaRequest;
import com.example.Usuario.Persona.Infraestructura.Adapters.Input.Rest.Model.Response.PersonaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CreacionRestPersonaMapper {

    Persona toCreacionPersona(creacionPersonaRequest persona);

    PersonaResponse toPersonaResponse(Persona persona);
}
