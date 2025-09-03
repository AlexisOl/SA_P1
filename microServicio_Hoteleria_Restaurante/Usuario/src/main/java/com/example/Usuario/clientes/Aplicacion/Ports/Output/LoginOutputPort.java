package com.example.Usuario.clientes.Aplicacion.Ports.Output;

import com.example.Usuario.clientes.Dominio.Model.Usuario;

public interface LoginOutputPort {

    String login(Usuario loginUsuarioDTO);
}
