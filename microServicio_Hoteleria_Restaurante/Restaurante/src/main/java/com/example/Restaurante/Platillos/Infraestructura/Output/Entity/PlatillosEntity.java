package com.example.Restaurante.Platillos.Infraestructura.Output.Entity;

import com.example.Restaurante.Platillos.Dominio.TipoPlatillo;
import com.example.Restaurante.Restaurante.Dominio.Restaurante;
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
@Table(name = "platillos")
public class PlatillosEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)

    private Double precio;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPlatillo tipo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idrestaurante", nullable = false)
    private RestauranteEntity idrestaurante;
}
