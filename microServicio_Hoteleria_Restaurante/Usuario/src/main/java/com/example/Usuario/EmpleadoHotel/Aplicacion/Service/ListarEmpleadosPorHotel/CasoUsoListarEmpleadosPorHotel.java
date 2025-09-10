package com.example.Usuario.EmpleadoHotel.Aplicacion.Service.ListarEmpleadosPorHotel;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.ListarEmpleadosPorHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.ListarEmpleadosPorHotelOutputPort;
import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasoUsoListarEmpleadosPorHotel  implements ListarEmpleadosPorHotelInputPort {


    private final ListarEmpleadosPorHotelOutputPort listarEmpleadosPorHotelOutputPort;


    public CasoUsoListarEmpleadosPorHotel(ListarEmpleadosPorHotelOutputPort listarEmpleadosPorHotelOutputPort){
        this.listarEmpleadosPorHotelOutputPort=listarEmpleadosPorHotelOutputPort;
    }
    @Override
    public List<EmpleadoHotel> listarEmpleadosPorHotel(Long id) {
        return this.listarEmpleadosPorHotelOutputPort.listarEmpleadosPorHotel(id);
    }
}
