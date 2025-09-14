package com.example.hoteleria.Rerservacion.Aplicacion.Service.CasosUso.ReservacionesPorHotel;

import com.example.hoteleria.Hotel.Aplicacion.Ports.Output.BuscarIdHotelOutputPersitenciaPuerto;
import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Input.ListarReservacionesHotelInputPort;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.ListarReservacionesHotelOutputPort;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarReservacionesPorHotel implements ListarReservacionesHotelInputPort {
    private final ListarReservacionesHotelOutputPort listarReservacionesHotelOutputPort;

    private final BuscarIdHotelOutputPersitenciaPuerto buscarIdHotelOutputPersitenciaPuerto;


    public ListarReservacionesPorHotel(ListarReservacionesHotelOutputPort listarReservacionesHotelOutputPort,
                                       BuscarIdHotelOutputPersitenciaPuerto buscarIdHotelOutputPersitenciaPuerto) {
        this.listarReservacionesHotelOutputPort = listarReservacionesHotelOutputPort;
        this.buscarIdHotelOutputPersitenciaPuerto=buscarIdHotelOutputPersitenciaPuerto;
    }
    @Override
    public List<Reservacion> listarReservacionesHotel(Long id) {
        if (this.buscarIdHotelOutputPersitenciaPuerto.buscarHotelId(id).isEmpty()) {
            throw new RuntimeException("NO existe el hotel");
        }
        return this.listarReservacionesHotelOutputPort.listarReservacionesHotel(id);
    }
}
