package com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Entity;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence.Entity.HabitacionEntity;
import com.example.hoteleria.Rerservacion.Dominio.TipoReservacion;
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
@Table(name = "reservacion")
public class ReservacionEntity {
    @Id
    @Column(name = "id", nullable = false, unique = true, length = 20)
    private UUID id;
    @Column(nullable = false)
    private LocalDate fechaEntrada;
    @Column(nullable = false)
    private LocalDate fechaSalida;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_habitacion", nullable = false)
    private HabitacionEntity habitacion;



    @Enumerated(EnumType.STRING)
    private TipoReservacion tipoReservacion;
    @Column(name = "id_usuario", nullable = false)
    private UUID id_usuario;
}
