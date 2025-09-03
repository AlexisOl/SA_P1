package com.example.Restaurante.Platillos.Aplicacion.Service.CasoUsoCrearPlatillo;

import com.example.Restaurante.Platillos.Aplicacion.Ports.Input.CrearPlatilloInputPort;
import com.example.Restaurante.Platillos.Aplicacion.Ports.Output.CrearPlatilloOutputPort;
import com.example.Restaurante.Platillos.Dominio.Platillos;
import com.example.Restaurante.Restaurante.Aplicacion.Ports.Output.ListarRestaurantesEspecificosOutputPort;
import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import com.example.Restaurante.Restaurante.Infraestructura.Output.RestaurantePesistenciaAdaptador;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CrearPlatillo implements CrearPlatilloInputPort {

    private final CrearPlatilloOutputPort crearPlatilloOutputPort;
    private final ListarRestaurantesEspecificosOutputPort listarRestaurantesEspecificosOutputPort;



    public CrearPlatillo(CrearPlatilloOutputPort crearPlatilloOutputPort,
                         ListarRestaurantesEspecificosOutputPort listarRestaurantesEspecificosOutputPort){
        this.crearPlatilloOutputPort = crearPlatilloOutputPort;
        this.listarRestaurantesEspecificosOutputPort = listarRestaurantesEspecificosOutputPort;
    }
    @Override
    public Platillos crearPlatillos(CrearPlatilloDTO crearPlatilloDTO) {

        Restaurante encontradoRestaurante = this.listarRestaurantesEspecificosOutputPort
                .listarRestaurantesEspecifico(crearPlatilloDTO.getIdrestaurante())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Restaurante no encontrado con id: " + crearPlatilloDTO.getIdrestaurante()
                ));


        return this.crearPlatilloOutputPort.crearPlatillos(
                new Platillos(
                        UUID.randomUUID(),
                        crearPlatilloDTO.getNombre(),
                        crearPlatilloDTO.getPrecio(),
                        crearPlatilloDTO.getTipo(),
                        encontradoRestaurante
                )
        );
    }
}
