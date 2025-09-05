package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Output.Entity;

import com.example.facturacion.DetalleFacturaRestaurante.Dominio.DetalleFacturaRestaurante;
import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;
import com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Entity.FacturaRestauranteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DetalleFacturaRestaurante")
public class DetalleFacturaRestauranteEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column( nullable = false)
    private UUID idplatillo;
    @Column( nullable = false)
    private Long cantidad;
    @Column( nullable = false)
    private Double precioParcial;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfacturaRestaurante", nullable = false)
    private FacturaRestauranteEntity facturaRestaurante;
}
