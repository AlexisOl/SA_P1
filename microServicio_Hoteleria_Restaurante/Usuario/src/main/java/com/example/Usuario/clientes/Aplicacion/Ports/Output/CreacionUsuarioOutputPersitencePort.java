package com.example.Usuario.clientes.Aplicacion.Ports.Output;

import com.example.Usuario.clientes.Dominio.Model.Usuario;

public interface CreacionUsuarioOutputPersitencePort {

    Usuario crearUsuario(Usuario usuario);
}
