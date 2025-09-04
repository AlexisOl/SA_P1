package com.example.hoteleria.Calificacion.Infraestructura.Output.Repository;

import com.example.hoteleria.Calificacion.Infraestructura.Output.Entity.CalificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CalificacionRepository extends JpaRepository<CalificacionEntity, UUID> {
}
