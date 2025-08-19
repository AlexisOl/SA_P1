package com.example.Usuario.clientes.infraestructura.Adapters.Input.Rest.Model.Response;

import com.example.Usuario.Persona.Dominio.Persona;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {
    private UUID id;
    private String username;
    private String password;
    private Persona persona;
}
