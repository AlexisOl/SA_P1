package com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Repository;

import com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Entity.FacturaRestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FacturaRestauranteRepository  extends JpaRepository<FacturaRestauranteEntity, UUID> {
}
