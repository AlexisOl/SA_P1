package com.example.Restaurante.Platillos.Infraestructura.Output.Repository;

import com.example.Restaurante.Platillos.Infraestructura.Output.Entity.PlatillosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PlatillosRepository extends JpaRepository<PlatillosEntity, UUID> {
    @Query("select '*' from PlatillosEntity p where p.idrestaurante =:idrestauranteId")
    List<PlatillosEntity> buscarPlatillosPorRestaurante(UUID idrestauranteId);
}
