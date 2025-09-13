package com.example.Usuario.clientes.Aplicacion.Service.LoginUsuario;

import com.example.Usuario.clientes.Aplicacion.Ports.Input.LoginInputPort;
import com.example.Usuario.clientes.Aplicacion.Ports.Output.AuthOutputPort;
import com.example.Usuario.clientes.Aplicacion.Ports.Output.TokenProviderOutputPort;
import com.example.Usuario.clientes.Dominio.Model.Usuario;
import com.example.Usuario.clientes.infraestructura.Adapters.Security.SecurityConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class LoginUsuarioCasoUso implements LoginInputPort {

    private final TokenProviderOutputPort tokenProvider;
    private final AuthOutputPort authOutputPort;
    private final SecurityConfig securityConfig;



    public LoginUsuarioCasoUso(TokenProviderOutputPort tokenProvider, AuthOutputPort authOutputPort,
                               SecurityConfig securityConfig) {
        this.tokenProvider = tokenProvider;
        this.authOutputPort = authOutputPort;
        this.securityConfig=securityConfig;
    }

    @Override
    public String login(LoginUsuarioDTO loginUsuarioDTO) {
        Usuario usuario = authOutputPort.buscarUsuarioPorUsername(loginUsuarioDTO.getUsername());
        securityConfig.passwordEncoder().matches(loginUsuarioDTO.getPassword(), usuario.getPassword());
        if (usuario == null || !securityConfig.passwordEncoder().matches(loginUsuarioDTO.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }


        return tokenProvider.generarToken(usuario);
    }
}
