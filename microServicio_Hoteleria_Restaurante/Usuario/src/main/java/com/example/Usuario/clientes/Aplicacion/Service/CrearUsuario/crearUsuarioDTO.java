package com.example.Usuario.clientes.Aplicacion.Service.CrearUsuario;


import com.example.Usuario.Persona.Dominio.Persona;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@AllArgsConstructor
public class crearUsuarioDTO {

    @NotBlank
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Long cui;
}
