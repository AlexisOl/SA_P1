package com.example.Restaurante.Restaurante.Infraestructura.Output.Repository;

import com.example.Restaurante.Restaurante.Infraestructura.Output.Entity.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestauranteRepository extends JpaRepository<RestauranteEntity, UUID> {
}
