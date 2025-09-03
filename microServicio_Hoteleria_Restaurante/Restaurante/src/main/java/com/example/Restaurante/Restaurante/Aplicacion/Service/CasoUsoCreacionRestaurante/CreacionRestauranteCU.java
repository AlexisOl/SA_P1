package com.example.Restaurante.Restaurante.Aplicacion.Service.CasoUsoCreacionRestaurante;

import com.example.Restaurante.Restaurante.Aplicacion.Ports.Input.CreacionRestauranteInputPort;
import com.example.Restaurante.Restaurante.Aplicacion.Ports.Output.CreacionRestauranteOutputPort;
import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreacionRestauranteCU implements CreacionRestauranteInputPort {

    private final CreacionRestauranteOutputPort creacionRestauranteOutputPort;



    public CreacionRestauranteCU(CreacionRestauranteOutputPort creacionRestauranteOutputPort) {
        this.creacionRestauranteOutputPort = creacionRestauranteOutputPort;
    }


    @Override
    public Restaurante crearRestaurante(CreacionRestauranteDTO restaurante) {

        return this.creacionRestauranteOutputPort.crearRestaurante(
                new Restaurante(
                        UUID.randomUUID(),
                        restaurante.getNombre(),
                        restaurante.getTelefono(),
                        restaurante.getDireccion(),
                        restaurante.getIdhotel()
                ));
    }
}
