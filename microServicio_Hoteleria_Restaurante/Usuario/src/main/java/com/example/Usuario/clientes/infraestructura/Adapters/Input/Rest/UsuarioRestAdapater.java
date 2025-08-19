package com.example.Usuario.clientes.infraestructura.Adapters.Input.Rest;

import com.example.Usuario.Persona.Aplicacion.Ports.input.creacionPersonaInputPort;
import com.example.Usuario.Persona.Aplicacion.Service.CrearPersona.crearPersonaDTO;
import com.example.Usuario.Persona.Infraestructura.Adapters.Input.Rest.Mapper.CreacionRestPersonaMapper;
import com.example.Usuario.Persona.Infraestructura.Adapters.Input.Rest.Model.Response.PersonaResponse;
import com.example.Usuario.clientes.Aplicacion.Ports.Input.CreacionUsuarioInputPort;
import com.example.Usuario.clientes.Aplicacion.Service.CrearUsuario.crearUsuarioDTO;
import com.example.Usuario.clientes.infraestructura.Adapters.Input.Rest.Mapper.CreacionUsuarioRestMapper;
import com.example.Usuario.clientes.infraestructura.Adapters.Input.Rest.Model.Response.UsuarioResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioRestAdapater {

    private final CreacionUsuarioRestMapper creacionUsuarioRestMapper;
    private final CreacionUsuarioInputPort creacionUsuarioInputPort;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioResponse> crearUsuario(@Valid @RequestBody crearUsuarioDTO usuarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.creacionUsuarioRestMapper.toUsuarioResponse(
                        creacionUsuarioInputPort.crearUsuario((usuarioDTO))
                ));
    }

}
