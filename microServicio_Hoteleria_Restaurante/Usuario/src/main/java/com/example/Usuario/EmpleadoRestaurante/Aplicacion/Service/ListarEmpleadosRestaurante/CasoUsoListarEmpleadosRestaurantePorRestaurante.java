package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Service.ListarEmpleadosRestaurante;


import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.ListarEmpleadosPorHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Input.ListarEmpleadosRestauranteHotelInputPort;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output.ListarEmpleadosRestaurantePorRestauranteOutPutPort;
import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CasoUsoListarEmpleadosRestaurantePorRestaurante implements ListarEmpleadosRestauranteHotelInputPort {


    private  final ListarEmpleadosRestaurantePorRestauranteOutPutPort listarEmpleadosRestaurantePorRestauranteOutPutPort;

    public CasoUsoListarEmpleadosRestaurantePorRestaurante(ListarEmpleadosRestaurantePorRestauranteOutPutPort listarEmpleadosRestaurantePorRestauranteOutPutPort) {
        this.listarEmpleadosRestaurantePorRestauranteOutPutPort = listarEmpleadosRestaurantePorRestauranteOutPutPort;
    }


    @Override
    public List<EmpleadoRestaurante> listarEmpleadosPorRestaurante(UUID id) {
        return this.listarEmpleadosRestaurantePorRestauranteOutPutPort.listarEmpleadosPorRestaurante(id);
    }
}
