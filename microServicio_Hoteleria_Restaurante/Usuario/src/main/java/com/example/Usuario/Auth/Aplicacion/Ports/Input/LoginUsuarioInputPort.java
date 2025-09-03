package com.example.Usuario.Auth.Aplicacion.Ports.Input;

import com.example.Usuario.Auth.Aplicacion.CasoUso.Login.LoginUsuarioDTO;
import com.example.Usuario.clientes.Dominio.Model.Usuario;

public interface LoginUsuarioInputPort {

    Boolean ingresoUsuario(LoginUsuarioDTO loginUsuarioDTO);
}
