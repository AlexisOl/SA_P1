package com.example.Usuario.EmpleadoHotel.Aplicacion.Service.ListarEmpleados;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.ListarEmpleadosHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.ListarEmpleadosHotelOutputPort;
import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CasoUsoListarEmpleados implements ListarEmpleadosHotelInputPort {

    private final ListarEmpleadosHotelOutputPort listarEmpleadosHotelOutputPort;

    public CasoUsoListarEmpleados(ListarEmpleadosHotelOutputPort listarEmpleadosHotelOutputPort) {
        this.listarEmpleadosHotelOutputPort = listarEmpleadosHotelOutputPort;
    }
    @Override
    public List<EmpleadoHotel> listarEmpleadosHotel() {
        return this.listarEmpleadosHotelOutputPort.listarEmpleadosHotel();
    }
}
