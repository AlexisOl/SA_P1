package com.example.Restaurante.Calificacion.Infraestructura.Output.Repository;

import com.example.Restaurante.Calificacion.Infraestructura.Output.Entity.CalificacionRestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CalificacionRestauranteRepository extends JpaRepository<CalificacionRestauranteEntity, UUID> {

    @Query("SELECT COALESCE(AVG(c.puntuacion), 0)  FROM CalificacionRestauranteEntity c WHERE c.platillo.id = :id")
    Double promedioValoracionPlatillos(UUID id);
}
