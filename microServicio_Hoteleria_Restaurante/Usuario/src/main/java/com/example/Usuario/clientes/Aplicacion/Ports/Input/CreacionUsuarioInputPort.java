package com.example.Usuario.clientes.Aplicacion.Ports.Input;

import com.example.Usuario.Persona.Aplicacion.Service.CrearPersona.crearPersonaDTO;
import com.example.Usuario.clientes.Aplicacion.Service.CrearUsuario.crearUsuarioDTO;
import com.example.Usuario.clientes.Dominio.Model.Usuario;
import jakarta.validation.Valid;

public interface CreacionUsuarioInputPort {

    Usuario crearUsuario( @Valid crearUsuarioDTO usuarioDTO);
}
