package com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Repository;

import com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Entity.EmpleadoRestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRestauranteRepository extends JpaRepository<EmpleadoRestauranteEntity, Integer> {
}
