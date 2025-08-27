package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detalle_factura")
public class DetalleFacturaEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(name = "id_reservacion", nullable = false)
    private UUID id_reservacion;
}
