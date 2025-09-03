package com.example.Usuario.clientes.Dominio.Model;

import com.example.Usuario.Persona.Dominio.Persona;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private UUID id;
    private String username;
    private String password;
    private Persona persona;
    private TipoEmpleado tipoEmpleado;

}
