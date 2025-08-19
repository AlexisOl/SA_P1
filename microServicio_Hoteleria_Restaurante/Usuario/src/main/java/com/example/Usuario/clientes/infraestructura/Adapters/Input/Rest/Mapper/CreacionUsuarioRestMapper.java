package com.example.Usuario.clientes.infraestructura.Adapters.Input.Rest.Mapper;

import com.example.Usuario.clientes.Dominio.Model.Usuario;
import com.example.Usuario.clientes.infraestructura.Adapters.Input.Rest.Model.Request.CreacionUsuarioRequest;
import com.example.Usuario.clientes.infraestructura.Adapters.Input.Rest.Model.Response.UsuarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreacionUsuarioRestMapper {
    Usuario toUsuarioRequest(CreacionUsuarioRequest creacionUsuarioRequest);

    UsuarioResponse toUsuarioResponse(Usuario usuario);
}
