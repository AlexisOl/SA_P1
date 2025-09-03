package com.example.Restaurante.Platillos.Infraestructura.Output.Repository;

import com.example.Restaurante.Platillos.Infraestructura.Output.Entity.PlatillosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlatillosRepository extends JpaRepository<PlatillosEntity, UUID> {
}
