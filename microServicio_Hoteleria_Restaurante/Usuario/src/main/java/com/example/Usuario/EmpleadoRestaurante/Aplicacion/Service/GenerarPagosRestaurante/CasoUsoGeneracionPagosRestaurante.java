package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Service.GenerarPagosRestaurante;

import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Input.GeneracionPagosRestauranteInputPort;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output.GeneracionPagosRestauranteOutputPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CasoUsoGeneracionPagosRestaurante implements GeneracionPagosRestauranteInputPort {

    private final GeneracionPagosRestauranteOutputPort  generacionPagosRestauranteOutputPort;

    public  CasoUsoGeneracionPagosRestaurante(GeneracionPagosRestauranteOutputPort  generacionPagosRestauranteOutputPort){
        this.generacionPagosRestauranteOutputPort=generacionPagosRestauranteOutputPort;
    }
    @Override
    public List<Object> perdidasPagosRestaurante(UUID id) {
        return this.generacionPagosRestauranteOutputPort.perdidasPagosRestaurante(id);
    }
}
