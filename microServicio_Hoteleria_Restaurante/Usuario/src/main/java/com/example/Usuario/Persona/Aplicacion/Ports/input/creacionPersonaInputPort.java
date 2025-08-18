package com.example.Usuario.Persona.Aplicacion.Ports.input;


import com.example.Usuario.Persona.Aplicacion.Service.CrearPersona.crearPersonaDTO;
import com.example.Usuario.Persona.Dominio.Persona;
import jakarta.validation.Valid;

public interface creacionPersonaInputPort {
    Persona creacionPersona( @Valid crearPersonaDTO personaDTO)  ;

}
