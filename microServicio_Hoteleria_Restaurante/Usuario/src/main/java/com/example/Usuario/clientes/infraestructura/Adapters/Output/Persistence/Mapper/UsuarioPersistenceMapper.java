package com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.Mapper;

import com.example.Usuario.Persona.Dominio.Persona;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Entity.PersonaEntity;
import com.example.Usuario.clientes.Dominio.Model.Usuario;
import com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.Entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")

public interface UsuarioPersistenceMapper {
    UsuarioEntity toUsuarioEntity(Usuario usuario);

    @Mapping(source = "tipoEmpleado", target = "tipoEmpleado")
    Usuario toPUssuario(UsuarioEntity usuarioEntity);
}
