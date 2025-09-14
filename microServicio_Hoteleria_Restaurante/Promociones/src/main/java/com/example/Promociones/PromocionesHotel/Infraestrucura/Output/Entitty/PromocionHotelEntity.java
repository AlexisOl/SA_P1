package com.example.Promociones.PromocionesHotel.Infraestrucura.Output.Entitty;

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
@Table(name = "promocionHotel")
public class PromocionHotelEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(nullable = false)
    private int cantidad_descuento;
    @Column(nullable = false)
    private LocalDate fecha_inicio;
    @Column(nullable = false)
    private LocalDate fecha_final;
    @Column(nullable = false)
    private UUID habitacion;
}
