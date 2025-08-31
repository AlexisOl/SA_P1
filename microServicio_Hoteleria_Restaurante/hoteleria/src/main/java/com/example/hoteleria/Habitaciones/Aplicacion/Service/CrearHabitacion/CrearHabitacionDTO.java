package com.example.hoteleria.Habitaciones.Aplicacion.Service.CrearHabitacion;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Habitaciones.Dominio.Model.TipoHabitacion;
import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.UUID;

@Value
@Getter
@Setter
public class CrearHabitacionDTO {
    @NotNull
    private Long numero_habitacion;
    @NotNull
    private Long cantidad_camas;
    @NotNull
    private Long id_hotel;

    @NotNull
    private TipoHabitacion tipoHabitacion;

    @NotNull
    private Double precio;


//    public Habitacion toDomain() {
//        return new Habitacion(UUID.randomUUID(), numero_habitacion, cantidad_camas, new Hotel(id_hotel));
//    }
//}
}