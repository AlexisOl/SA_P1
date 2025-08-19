package com.example.Usuario.Persona.Aplicacion.Ports.output;

import com.example.Usuario.Persona.Dominio.Persona;

import java.util.Optional;

public interface BusquedaPersonaCuiOutputPersistencia {
    Optional<Persona> buscarPersona(Long cui);

}
