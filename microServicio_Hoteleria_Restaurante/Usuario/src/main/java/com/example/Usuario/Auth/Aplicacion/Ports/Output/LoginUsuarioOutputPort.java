package com.example.Usuario.Auth.Aplicacion.Ports.Output;

import com.example.Usuario.Auth.Aplicacion.CasoUso.Login.LoginUsuarioDTO;
import com.example.Usuario.clientes.Dominio.Model.Usuario;

public interface LoginUsuarioOutputPort {

    Boolean ingresoUsuario(Usuario usuario);

}
