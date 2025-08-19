package com.example.Usuario.clientes.infraestructura.Adapters.Input.Rest.Model.Request;

import com.example.Usuario.Persona.Dominio.Persona;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreacionUsuarioRequest {
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private String username;
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private String password;
    @NotEmpty(message = "No pueden haber campos vacios ni nulos")
    private Long cui;

}
