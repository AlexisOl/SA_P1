package com.example.Usuario.EmpleadoHotel.Aplicacion.Service.ListarEmpleadoEspecifico;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.ListarEmpleadoEspecificoHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.ListarEmpleadoEspecificoHotelOutputPort;
import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service

public class CasoUsoListarEmpleadoEspecificoHotel implements ListarEmpleadoEspecificoHotelInputPort {
    
    private final ListarEmpleadoEspecificoHotelOutputPort listarEmpleadoEspecificoHotelOutputPort;
    
    public CasoUsoListarEmpleadoEspecificoHotel(ListarEmpleadoEspecificoHotelOutputPort listarEmpleadoEspecificoHotelOutputPort) {
        this.listarEmpleadoEspecificoHotelOutputPort =  listarEmpleadoEspecificoHotelOutputPort;
    }
    @Override
    public Optional<EmpleadoHotel> ListarEmpleadoEspecificoHotel(UUID id) {
        return this.listarEmpleadoEspecificoHotelOutputPort.ListarEmpleadoEspecificoHotel(id);
    }
}
