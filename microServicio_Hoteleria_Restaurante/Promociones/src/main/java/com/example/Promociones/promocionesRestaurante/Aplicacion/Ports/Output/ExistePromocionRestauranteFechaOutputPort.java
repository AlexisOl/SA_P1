package com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Output;

import java.time.LocalDate;
import java.util.UUID;

public interface ExistePromocionRestauranteFechaOutputPort {
    boolean existePromocionPlatilloFecha(UUID platillo, LocalDate fechaInicio, LocalDate fechaFinal);

}
