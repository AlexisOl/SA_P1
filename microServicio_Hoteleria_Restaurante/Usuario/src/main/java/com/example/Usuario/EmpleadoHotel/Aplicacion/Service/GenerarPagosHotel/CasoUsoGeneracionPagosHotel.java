package com.example.Usuario.EmpleadoHotel.Aplicacion.Service.GenerarPagosHotel;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.GeneracionPagosHotelnputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.GeneracionPagosHotelOutputPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasoUsoGeneracionPagosHotel implements GeneracionPagosHotelnputPort {
    private final GeneracionPagosHotelOutputPort generacionPagosHotelOutputPort;


    public CasoUsoGeneracionPagosHotel(GeneracionPagosHotelOutputPort generacionPagosHotelOutputPort) {
        this.generacionPagosHotelOutputPort=generacionPagosHotelOutputPort;
    }
    @Override
    public List<Object> perdidasPagosHotel(Long id) {
        return this.generacionPagosHotelOutputPort.perdidasPagosHotel(id);
    }
}
