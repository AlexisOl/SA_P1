package com.example.Usuario.EmpleadoHotel.Aplicacion.Service.ReporteDetalleEmpleadoHotel;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.ReporteDetalleEmpleadoHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.ReporteDetalleEmpleadoHotelOutputPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CasoUsoReporteDetalleEmpleadoHotel implements ReporteDetalleEmpleadoHotelInputPort {
    private final ReporteDetalleEmpleadoHotelOutputPort ReporteDetalleEmpleadoHotelOutputPort;


    public CasoUsoReporteDetalleEmpleadoHotel(ReporteDetalleEmpleadoHotelOutputPort ReporteDetalleEmpleadoHotelOutputPort) {
        this.ReporteDetalleEmpleadoHotelOutputPort = ReporteDetalleEmpleadoHotelOutputPort;
    }
    @Override
    public List<Object> detalleEmpleadoHotelReporteDTO(UUID id) {
        //existe empleado

        return this.ReporteDetalleEmpleadoHotelOutputPort.detalleEmpleadoHotelReporteDTO(id);
    }
}
