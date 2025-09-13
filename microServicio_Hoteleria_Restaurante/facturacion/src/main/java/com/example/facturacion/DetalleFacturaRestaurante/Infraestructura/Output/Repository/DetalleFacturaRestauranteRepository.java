package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Output.Repository;

import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Output.Entity.DetalleFacturaRestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DetalleFacturaRestauranteRepository extends JpaRepository<DetalleFacturaRestauranteEntity, Long> {
    List<DetalleFacturaRestauranteEntity> findAllByFacturaRestaurante_Id(UUID facturaRestauranteId);
}
