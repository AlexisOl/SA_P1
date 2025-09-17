package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Service.ReporteDetalleEmpleadosRestaurante;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.ReporteDetalleEmpleadoHotelInputPort;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Input.ReporteDetalladoEmpleadoRestauranteInputPort;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output.ReporteDetalladoEmpleadoRestauranteOutputPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class CsaoUsoDetalleEmpleadoRestaurante implements ReporteDetalladoEmpleadoRestauranteInputPort {

    private final ReporteDetalladoEmpleadoRestauranteOutputPort reporteDetalladoEmpleadoRestauranteOutputPort;


    public CsaoUsoDetalleEmpleadoRestaurante(ReporteDetalladoEmpleadoRestauranteOutputPort reporteDetalladoEmpleadoRestauranteOutputPort){
        this.reporteDetalladoEmpleadoRestauranteOutputPort=reporteDetalladoEmpleadoRestauranteOutputPort;
    }
    @Override
    public List<Object> detalleEmpleadoRestauranteReporteDTO(UUID id) {
        return this.reporteDetalladoEmpleadoRestauranteOutputPort.detalleEmpleadoRestauranteReporteDTO(id);
    }
}
