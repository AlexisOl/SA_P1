package com.example.Restaurante.Calificacion.Infraestructura.Output.Entity;

import com.example.Restaurante.Platillos.Dominio.TipoPlatillo;
import com.example.Restaurante.Platillos.Infraestructura.Output.Entity.PlatillosEntity;
import com.example.Restaurante.Restaurante.Infraestructura.Output.Entity.RestauranteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "calificacionRestaurante")
public class CalificacionRestauranteEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(nullable = true)
    private String comentario;
    @Column(nullable = true)
    private Double puntuacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idplatillos", nullable = false)
    private PlatillosEntity platillo;
}
