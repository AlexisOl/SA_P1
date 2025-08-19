package com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Repository;

import com.example.Usuario.Persona.Dominio.Persona;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

    PersonaEntity findPersonaEntityByCui(Long cui);
}
