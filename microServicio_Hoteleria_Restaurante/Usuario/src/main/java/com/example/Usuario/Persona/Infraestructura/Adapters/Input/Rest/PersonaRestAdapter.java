package com.example.Usuario.Persona.Infraestructura.Adapters.Input.Rest;


import com.example.Usuario.Persona.Aplicacion.Ports.input.creacionPersonaInputPort;
import com.example.Usuario.Persona.Aplicacion.Service.CrearPersona.crearPersonaDTO;
import com.example.Usuario.Persona.Infraestructura.Adapters.Input.Rest.Mapper.CreacionRestPersonaMapper;
import com.example.Usuario.Persona.Infraestructura.Adapters.Input.Rest.Model.Request.creacionPersonaRequest;
import com.example.Usuario.Persona.Infraestructura.Adapters.Input.Rest.Model.Response.PersonaResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/persona")

public class PersonaRestAdapter {
    private final CreacionRestPersonaMapper creacionRestPersonaMapper;
    private final creacionPersonaInputPort creacionPersonaInput;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PersonaResponse> crearPersona(@Valid @RequestBody crearPersonaDTO persona) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.creacionRestPersonaMapper.toPersonaResponse(
                        creacionPersonaInput.creacionPersona((persona))
                ));
    }




}
