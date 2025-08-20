package com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence.Entity;


import com.example.hoteleria.Hotel.Infraestructura.Adapters.Output.Persistence.Entity.HotelEntity;
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
@Table(name = "habitacion")
public class HabitacionEntity {
    @Id
    @Column(name = "id", nullable = false, unique = true, length = 20)
    private UUID id;
    @Column(nullable = false)
    private Long numero_habitacion;
    @Column(nullable = false)
    private Long cantidad_camas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hotel", nullable = false)
    private HotelEntity hotel;


}
