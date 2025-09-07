package com.example.hoteleria.Calificacion.Aplicacion.Service.CasosUso.ListarHabitacionesHotel;

import com.example.hoteleria.Calificacion.Aplicacion.Ports.Input.ListarCalificacionesInputPort;
import com.example.hoteleria.Calificacion.Aplicacion.Ports.Output.ListarCalificacionesOutputPort;
import com.example.hoteleria.Calificacion.Dominio.Calificacion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListarHabitacion implements ListarCalificacionesInputPort {

    private final ListarCalificacionesOutputPort listarCalificacionesOutputPort;


    public ListarHabitacion(ListarCalificacionesOutputPort listarCalificacionesOutputPort){
        this.listarCalificacionesOutputPort=listarCalificacionesOutputPort;
    }

    @Override
    public List<Calificacion> listarCalificacionesPorHabitacion(UUID id) {
        return this.listarCalificacionesOutputPort.listarCalificacionesPorHabitacion(id);
    }
}
