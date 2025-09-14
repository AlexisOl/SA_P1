package com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output;

import java.time.LocalDate;
import java.util.UUID;

public interface ExistePromocionHabitacionFechaOutputPort {
    boolean existePromocionHabitacionFecha(UUID habiacion, LocalDate fechaInicio, LocalDate fechaFinal);
}
