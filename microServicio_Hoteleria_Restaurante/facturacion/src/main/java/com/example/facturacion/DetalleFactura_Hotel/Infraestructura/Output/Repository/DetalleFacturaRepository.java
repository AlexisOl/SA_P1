package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Repository;

import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.DetalleFacturaPersitenciaAdapatador;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Entity.DetalleFacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFacturaEntity, UUID> {
}
