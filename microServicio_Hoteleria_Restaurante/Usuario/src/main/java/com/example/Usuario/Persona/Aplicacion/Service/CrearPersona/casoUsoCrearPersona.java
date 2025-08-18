package com.example.Usuario.Persona.Aplicacion.Service.CrearPersona;

import com.example.Usuario.Persona.Aplicacion.Ports.input.creacionPersonaInputPort;
import com.example.Usuario.Persona.Aplicacion.Ports.output.creacionPersonaOutputPersistenciaPuerto;
import com.example.Usuario.Persona.Dominio.Persona;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.bouncycastle.asn1.x509.sigi.PersonalData;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class casoUsoCrearPersona implements creacionPersonaInputPort {

    private final creacionPersonaOutputPersistenciaPuerto personaOutputPersistenciaPuerto;


    @Override
    @Transactional
    public Persona creacionPersona(crearPersonaDTO personaDTO) {

        //ver si ya existe el correo


        Persona nuevaPersona = personaDTO.toDomain();
        // persietencia
        Persona personaGuardada = personaOutputPersistenciaPuerto.creacionPersona(nuevaPersona);

        return  personaGuardada;
    }
}
