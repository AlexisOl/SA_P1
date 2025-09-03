package com.example.Usuario.clientes.Aplicacion.Ports.Output;

import com.example.Usuario.clientes.Dominio.Model.Usuario;

public interface AuthOutputPort {
    Usuario buscarUsuarioPorUsername(String username);
}
