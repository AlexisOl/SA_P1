package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Repository;

import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.DetalleFacturaPersitenciaAdapatador;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Entity.DetalleFacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFacturaEntity, UUID> {
    @Query("SELECT d FROM DetalleFacturaEntity d WHERE d.id_reservacion = :idReservacion")
    Optional<DetalleFacturaEntity> findById_reservacion(UUID idReservacion);

}
