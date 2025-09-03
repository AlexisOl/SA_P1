package com.example.Restaurante.Restaurante.Aplicacion.Service.CasoUsoListarRestaurante;

import com.example.Restaurante.Restaurante.Aplicacion.Ports.Input.ListarRestaturantesInputPort;
import com.example.Restaurante.Restaurante.Aplicacion.Ports.Output.ListarRestaurantesOutputPort;
import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import com.example.Restaurante.Restaurante.Infraestructura.Output.Mapper.RestauranteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarRestaurantes implements ListarRestaturantesInputPort {

    private final ListarRestaurantesOutputPort listarRestaurantesOutputPort;


    public ListarRestaurantes(ListarRestaurantesOutputPort listarRestaurantesOutputPort) {
        this.listarRestaurantesOutputPort = listarRestaurantesOutputPort;
    }

    @Override
    public List<Restaurante> listarRestaurantes() {
        return this.listarRestaurantesOutputPort.listarRestaurantes();
    }
}
