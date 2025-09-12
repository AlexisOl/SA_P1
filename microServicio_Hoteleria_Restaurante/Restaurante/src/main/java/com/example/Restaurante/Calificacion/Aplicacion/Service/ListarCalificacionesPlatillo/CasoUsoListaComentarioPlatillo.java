package com.example.Restaurante.Calificacion.Aplicacion.Service.ListarCalificacionesPlatillo;

import com.example.Restaurante.Calificacion.Aplicacion.Ports.Input.ListarComentarioPlatilloInputPort;
import com.example.Restaurante.Calificacion.Aplicacion.Ports.Output.ListarComentarioPlatilloOutputPort;
import com.example.Restaurante.Calificacion.Dominio.CalificacionRestaurante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class CasoUsoListaComentarioPlatillo implements ListarComentarioPlatilloInputPort {


    private final ListarComentarioPlatilloOutputPort listarComentarioPlatilloOutputPort;


    public CasoUsoListaComentarioPlatillo(ListarComentarioPlatilloOutputPort listarComentarioPlatilloOutputPort){
        this.listarComentarioPlatilloOutputPort = listarComentarioPlatilloOutputPort;
    }

    @Override
    public List<CalificacionRestaurante> listarComentarioPlatillo(UUID id) {
        return this.listarComentarioPlatilloOutputPort.listarComentarioPlatillo(id);
    }
}
