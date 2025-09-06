package com.example.Restaurante.Calificacion.Infraestructura.Output.Repository;

import com.example.Restaurante.Calificacion.Infraestructura.Output.Entity.CalificacionRestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CalificacionRestauranteRepository extends JpaRepository<CalificacionRestauranteEntity, UUID> {
}
