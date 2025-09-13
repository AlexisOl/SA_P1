package com.example.Restaurante.Platillos.Aplicacion.Service.CasoUsoListarPlatillosGlobales;

import com.example.Restaurante.Platillos.Aplicacion.Ports.Input.ListarPlatillosGlobalesInputPort;
import com.example.Restaurante.Platillos.Aplicacion.Ports.Output.ListarPlatillosGlobalesOutputPort;
import com.example.Restaurante.Platillos.Dominio.Platillos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarPlatillosGlobales implements ListarPlatillosGlobalesInputPort {

    private final ListarPlatillosGlobalesOutputPort listarPlatillosGlobalesOutputPort;

    public ListarPlatillosGlobales(ListarPlatillosGlobalesOutputPort listarPlatillosGlobalesOutputPort){
        this.listarPlatillosGlobalesOutputPort=listarPlatillosGlobalesOutputPort;
    }

    @Override
    public List<Platillos> listarPlatillosGlobales() {
        return this.listarPlatillosGlobalesOutputPort.listarPlatillosGlobales();
    }
}
