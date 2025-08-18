package com.example.Usuario.clientes.Aplicacion.Service.CrearUsuario;


import com.example.Usuario.clientes.Aplicacion.Ports.Input.CreacionUsuarioInputPort;
import com.example.Usuario.clientes.Dominio.Model.Usuario;
import org.springframework.stereotype.Service;

@Service


public class casoUsoCrearUsuario implements CreacionUsuarioInputPort {

    @Override
    public Usuario crearUsuario(crearUsuarioDTO usuarioDTO) {
        return null;
    }
}
