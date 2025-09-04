package com.example.hoteleria.Calificacion.Infraestructura.Output.Entity;

import com.example.hoteleria.Calificacion.Dominio.Puntuacion;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Entity.ReservacionEntity;
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
@Table(name = "calificacion")
public class CalificacionEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String comentario;
 //   @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Double puntuacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idreservacion", nullable = false)
    private ReservacionEntity reservacion;
}
