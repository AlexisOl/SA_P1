package com.example.Restaurante.Calificacion.Aplicacion.Service.CrearCalificacion;

import com.example.Restaurante.Calificacion.Aplicacion.Ports.Input.CrearCalificacionRestauranteInputPort;
import com.example.Restaurante.Calificacion.Aplicacion.Ports.Output.CrearCalificacionRestauranteOutputPort;
import com.example.Restaurante.Calificacion.Dominio.CalificacionRestaurante;
import com.example.Restaurante.Platillos.Aplicacion.Ports.Output.ListarPlatilloEspecificoOutputPort;
import com.example.Restaurante.Platillos.Dominio.Platillos;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CasoUsoCrearCalificacionRestaurante  implements CrearCalificacionRestauranteInputPort {

    private final CrearCalificacionRestauranteOutputPort crearCalificacionRestauranteOutputPort;
    private final ListarPlatilloEspecificoOutputPort listarPlatilloEspecificoOutputPort;


    public CasoUsoCrearCalificacionRestaurante(CrearCalificacionRestauranteOutputPort crearCalificacionRestauranteOutputPort,
                                               ListarPlatilloEspecificoOutputPort listarPlatilloEspecificoOutputPort){
        this.crearCalificacionRestauranteOutputPort = crearCalificacionRestauranteOutputPort;
        this.listarPlatilloEspecificoOutputPort=listarPlatilloEspecificoOutputPort;
    }

    @Override
    public CalificacionRestaurante createCalificacionRestaurante(List<CrearCalificacionRestauranteDTO> crearCalificacionRestauranteDTO) {
        // aca comprobar que existe el platillo

        for (CrearCalificacionRestauranteDTO resenias: crearCalificacionRestauranteDTO){
            Platillos nuevoPlatillo = this.listarPlatilloEspecificoOutputPort.listarPlatillosEspecificos(resenias.getPlatillo());
            if (!(nuevoPlatillo==null)){
                throw  new EntityNotFoundException("no existe el platillo");
            }
            System.out.println(nuevoPlatillo.getNombre());
            // creacion
            this.crearCalificacionRestauranteOutputPort.createCalificacionRestaurante(
                    new CalificacionRestaurante(
                            UUID.randomUUID(),
                            resenias.getComentario(),
                            resenias.getPuntuacion(),
                            nuevoPlatillo
                    )
            );
        }
        return null;
    }
}
