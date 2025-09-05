package com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Entity;


import com.example.facturacion.Factura_Restaurante.Dominio.ObjetosValor.PrecioFactura;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "FacturaRestaurante")
public class FacturaRestauranteEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column( nullable = false)
    private LocalDate fecha;
    @Column( nullable = false)
    private UUID id_Cliente;
    @Column( nullable = false)
    private Double precioTotal;

}
