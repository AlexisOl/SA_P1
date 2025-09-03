package com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence;

import com.example.Usuario.clientes.Aplicacion.Ports.Output.TokenProviderOutputPort;
import com.example.Usuario.clientes.Dominio.Model.Usuario;
import com.example.Usuario.clientes.infraestructura.Adapters.Security.JWTServicio;
import org.springframework.stereotype.Component;

@Component
public class JWTTokenAdapter implements TokenProviderOutputPort {

    private final JWTServicio jwtServicio;

    public JWTTokenAdapter(JWTServicio jwtServicio) {
        this.jwtServicio = jwtServicio;
    }

    @Override
    public String generarToken(Usuario usuario) {
        return jwtServicio.obtenerToken(usuario);
    }
}