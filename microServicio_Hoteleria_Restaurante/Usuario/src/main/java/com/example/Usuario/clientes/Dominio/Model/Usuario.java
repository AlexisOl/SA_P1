package com.example.Usuario.clientes.Dominio.Model;

import com.example.Usuario.Persona.Dominio.Persona;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@Builder
public class Usuario {
    private UUID id;
    private String username;
    private String password;
    private Persona persona;

}
