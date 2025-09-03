package com.example.Restaurante.Restaurante.Aplicacion.Service.CasoUsoListarRestaurantesEspecificos;

import com.example.Restaurante.Restaurante.Aplicacion.Ports.Input.ListarRestaurantesEspecificosInputPort;
import com.example.Restaurante.Restaurante.Aplicacion.Ports.Output.ListarRestaurantesEspecificosOutputPort;
import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ListarRestauranteEspecifico implements ListarRestaurantesEspecificosInputPort {
    private final ListarRestaurantesEspecificosOutputPort  listarRestaurantesEspecificosOutputPort;


    public ListarRestauranteEspecifico(ListarRestaurantesEspecificosOutputPort listarRestaurantesEspecificosOutputPort){
        this.listarRestaurantesEspecificosOutputPort= listarRestaurantesEspecificosOutputPort;
    }
    @Override
    public Restaurante listarRestauranteEspecifico(UUID id) {
        // ver si existe

        return this.listarRestaurantesEspecificosOutputPort.listarRestaurantesEspecifico(id);
    }
}
