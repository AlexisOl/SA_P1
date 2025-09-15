package com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output;

import java.time.LocalDate;
import java.util.UUID;

public interface hayTraslapeOutputPort {
    boolean existeTraslape(UUID habitacion, LocalDate fechaInicio, LocalDate fechaFinal);
}
