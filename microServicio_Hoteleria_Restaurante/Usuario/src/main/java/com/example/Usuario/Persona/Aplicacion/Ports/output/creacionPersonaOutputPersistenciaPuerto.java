package com.example.Usuario.Persona.Aplicacion.Ports.output;

import com.example.Usuario.Persona.Aplicacion.Service.CrearPersona.crearPersonaDTO;
import com.example.Usuario.Persona.Dominio.Persona;
import jakarta.validation.Valid;

public interface creacionPersonaOutputPersistenciaPuerto {
    Persona creacionPersona( Persona persona);
}
