package com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Repository;

import com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Entity.FacturaRestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FacturaRestauranteRepository  extends JpaRepository<FacturaRestauranteEntity, UUID> {
    @Query("SELECT f from FacturaRestauranteEntity f where f.id_Cliente =:idUsuario")
    List<FacturaRestauranteEntity> findAllByCliente(UUID idUsuario);
}
