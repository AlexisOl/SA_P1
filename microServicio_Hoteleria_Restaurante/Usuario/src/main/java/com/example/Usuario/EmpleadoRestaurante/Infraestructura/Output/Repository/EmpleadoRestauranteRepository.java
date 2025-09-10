package com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Repository;

import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;
import com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Entity.EmpleadoRestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface EmpleadoRestauranteRepository extends JpaRepository<EmpleadoRestauranteEntity, UUID> {
    @Query("SELECT e FROM EmpleadoRestauranteEntity e where e.restauranteId= :restauranteId")
    List<EmpleadoRestauranteEntity> findAllByRestauranteId(UUID restauranteId);
}
