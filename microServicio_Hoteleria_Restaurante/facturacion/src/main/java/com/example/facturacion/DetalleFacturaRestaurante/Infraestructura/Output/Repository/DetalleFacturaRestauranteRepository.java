package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Output.Repository;

import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Output.Entity.DetalleFacturaRestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRestauranteRepository extends JpaRepository<DetalleFacturaRestauranteEntity, Long> {
}
