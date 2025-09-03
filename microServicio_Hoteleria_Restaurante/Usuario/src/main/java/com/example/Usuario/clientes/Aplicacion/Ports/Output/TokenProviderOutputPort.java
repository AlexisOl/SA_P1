package com.example.Usuario.clientes.Aplicacion.Ports.Output;

import com.example.Usuario.clientes.Dominio.Model.Usuario;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface TokenProviderOutputPort {
    String generarToken(Usuario user);
}
