package com.example.Usuario.clientes.Aplicacion.Ports.Input;

import com.example.Usuario.clientes.Aplicacion.Service.LoginUsuario.LoginUsuarioDTO;
import com.example.Usuario.clientes.Dominio.Model.Usuario;

public interface LoginInputPort {

    String login(LoginUsuarioDTO loginUsuarioDTO);
}
